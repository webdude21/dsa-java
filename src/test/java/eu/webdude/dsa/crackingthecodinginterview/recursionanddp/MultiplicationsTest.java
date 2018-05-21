package eu.webdude.dsa.crackingthecodinginterview.recursionanddp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplicationsTest {

  @ParameterizedTest
  @CsvSource({"2, 5", "1212, 2132123", "-10, 52", "31, 354", "0, 2132123"})
  void testMultiply(int a, int b) {
    int expected = a * b;
    assertEquals(expected, Multiplications.multiply(a, b));
    assertEquals(expected, Multiplications.multiplyRecursive(a, b));
  }
}
