package eu.webdude.dsa.crackingthecodinginterview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RecursionAndDynamicProgrammingTest {

  @Test
  void tripleStep() {
    Assertions.assertEquals(7, RecursionAndDynamicProgramming.tripleStep(4));
    Assertions.assertEquals(927, RecursionAndDynamicProgramming.tripleStep(12));
  }
}
