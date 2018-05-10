package eu.webdude.dsa.crackingthecodinginterview;

import eu.webdude.dsa.datastructures.DoublyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListChallengesTest {

  @Test
  void removeDuplicates() {
    var testInput = getTestInput();
    var expectedOutput = getExpectedOutputWithoutDuplicates();

    testInput.removeDuplicates();

    assertEquals(testInput, expectedOutput);
    assertArrayEquals(testInput.toArray(), expectedOutput.toArray());
  }

  @Test
  void isPalindrome() {
    var oddPalindrome = getTestInputForOddPalindrome();
    var evenPalindrome = getTestInputForEvenPalindrome();
    var nonPalindrome = getTestInput();

    Assertions.assertTrue(evenPalindrome.isPalindrome());
    Assertions.assertTrue(oddPalindrome.isPalindrome());
    Assertions.assertFalse(nonPalindrome.isPalindrome());
  }

  @Test
  void deleteMiddleNode() {
    var testInput = getTestInput();
    var expectedOutput = getExpectedOutputWithTheMiddleElementRemoved();

    testInput.removeMiddleElement();

    Assertions.assertEquals(testInput, expectedOutput);
    Assertions.assertArrayEquals(testInput.toArray(), expectedOutput.toArray());
  }

  @Test
  void findKthToLast() {
    var testInput = getTestInput();

    Assertions.assertEquals(testInput.nthToLast(3), Integer.valueOf(3));
    Assertions.assertEquals(testInput.nthToLast(4), Integer.valueOf(4));
    Assertions.assertEquals(testInput.nthToLast(8), Integer.valueOf(1));
  }

  private DoublyLinkedList<Integer> getTestInputForEvenPalindrome() {
    DoublyLinkedList<Integer> input = new DoublyLinkedList<>();

    input.addLast(1);
    input.addLast(2);
    input.addLast(3);
    input.addLast(3);
    input.addLast(2);
    input.addLast(1);

    return input;
  }

  private DoublyLinkedList<Integer> getTestInputForOddPalindrome() {
    DoublyLinkedList<Integer> input = new DoublyLinkedList<>();

    input.addLast(1);
    input.addLast(2);
    input.addLast(3);
    input.addLast(4);
    input.addLast(3);
    input.addLast(2);
    input.addLast(1);

    return input;
  }

  private DoublyLinkedList<Integer> getExpectedOutputWithTheMiddleElementRemoved() {
    DoublyLinkedList<Integer> input = new DoublyLinkedList<>();

    input.addLast(1);
    input.addLast(2);
    input.addLast(3);
    input.addLast(1);
    input.addLast(3);
    input.addLast(5);
    input.addLast(6);
    input.addLast(7);

    return input;
  }

  private DoublyLinkedList<Integer> getExpectedOutputWithoutDuplicates() {
    DoublyLinkedList<Integer> input = new DoublyLinkedList<>();

    input.addLast(1);
    input.addLast(2);
    input.addLast(3);
    input.addLast(4);
    input.addLast(5);
    input.addLast(6);
    input.addLast(7);

    return input;
  }

  private DoublyLinkedList<Integer> getTestInput() {
    DoublyLinkedList<Integer> input = new DoublyLinkedList<>();

    input.addLast(1);
    input.addLast(2);
    input.addLast(3);
    input.addLast(1);
    input.addLast(4);
    input.addLast(3);
    input.addLast(5);
    input.addLast(6);
    input.addLast(7);

    return input;
  }
}
