package eu.webdude.dsa.algo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseStringTest {

  @Test
  void reverseStringTest() {
    Assertions.assertEquals("rac", ReverseString.reverseString("car"));
  }
}
