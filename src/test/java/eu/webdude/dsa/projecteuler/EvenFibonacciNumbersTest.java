package eu.webdude.dsa.projecteuler;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class EvenFibonacciNumbersTest {

  @Test
  void sum() {
    assertEquals(BigInteger.valueOf(4613732), EvenFibonacciNumbers.sum(4_000_000));
    assertEquals(BigInteger.valueOf(4613732), EvenFibonacciNumbers.sumIterative(4_000_000));
  }
}
