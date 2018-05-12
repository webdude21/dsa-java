package eu.webdude.dsa.algo;

import eu.webdude.dsa.algo.atm.AtmMachine;
import eu.webdude.dsa.algo.atm.Bill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class AtmMachineTest implements ArgumentsProvider {

  private List<Bill> bills = Arrays.asList(
    Bill.of(91, 2),
    Bill.of(26, 5),
    Bill.of(83, 10),
    Bill.of(58, 20),
    Bill.of(15, 50),
    Bill.of(10, 100)
  );

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(bills, 7, Arrays.asList(Bill.of(2, 1), Bill.of(5, 1)))
    );
  }

  @ParameterizedTest
  @ArgumentsSource(AtmMachineTest.class)
  void name(List<Bill> bills, int takeOutAmount, List<Bill> expected) {
    AtmMachine atmMachine = new AtmMachine(bills);

    Collections.sort(expected);

    List<Bill> actualBills = atmMachine.takeOut(takeOutAmount);

    Assertions.assertArrayEquals(actualBills.toArray(), expected.toArray());
  }
}
