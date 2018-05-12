package eu.webdude.dsa.crackingthecodinginterview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinStackTest {

  private MinStack<Integer> minStack;

  @BeforeEach
  void setUp() {
    minStack = new MinStack<>();
  }

  @Test
  void pushingIntoTheStack() {
    minStack.push(5);
  }

  @Test
  void poppingAnItemOutOfTheStack() {
    int expected = 5;
    minStack.push(expected);
    int actual = minStack.pop();

    Assertions.assertEquals(expected, actual);
  }

  @Test
  void gettingTheMinItemOut() {
    minStack.push(3);
    minStack.push(5);
    minStack.push(1);
    minStack.push(6);
    minStack.push(18);

    int actual = minStack.min();

    Assertions.assertEquals(1, actual);
  }
}
