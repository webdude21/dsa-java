package eu.webdude.dsa.algo;

import eu.webdude.dsa.algo.atm.AtmMachine;
import eu.webdude.dsa.algo.atm.Bill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
    Bill.of(2, 91),
    Bill.of(5, 26),
    Bill.of(10, 83),
    Bill.of(20, 58),
    Bill.of(50, 15),
    Bill.of(100, 10)
  );

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(bills, 8, Collections.singletonList(Bill.of(2, 4))),
      Arguments.of(bills, 7, Arrays.asList(Bill.of(5, 1), Bill.of(2, 1))),
      Arguments.of(bills, 17, Arrays.asList(Bill.of(10, 1), Bill.of(5, 1), Bill.of(2, 1))),
      Arguments.of(bills, 18, Arrays.asList(Bill.of(10, 1), Bill.of(2, 4))),
      Arguments.of(bills, 118, Arrays.asList(Bill.of(100, 1), Bill.of(10, 1), Bill.of(2, 4)))
    );
  }

  @BeforeEach
  void setUp() {

  }

  @ParameterizedTest
  @ArgumentsSource(AtmMachineTest.class)
  void testForCertainBillSizes(List<Bill> bills, int takeOutAmount, List<Bill> expected) {
    var atmMachine = new AtmMachine(bills);

    var actualBills = atmMachine.takeOut(takeOutAmount);

    Assertions.assertArrayEquals(actualBills.toArray(), expected.toArray());
  }

  @ParameterizedTest
  @ArgumentsSource(AtmMachineTest.class)
  void testIfAmountIsOk(List<Bill> bills, int takeOutAmount) {
    var atmMachine = new AtmMachine(bills);

    var actual = atmMachine.takeOut(takeOutAmount).stream().mapToInt(Bill::getTotal).sum();

    Assertions.assertEquals(takeOutAmount, actual);
  }
}
