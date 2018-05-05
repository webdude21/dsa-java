package eu.webdude.dsa.crackingthecodinginterview;

import eu.webdude.dsa.datastructures.DoublyLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListChallengesTest {

    @Test
    public void removeDuplicates() {
        DoublyLinkedList<Integer> testInput = getTestInput();
        DoublyLinkedList<Integer> expectedOutput = getExpectedOutputWithoutDuplicates();

        testInput.removeDuplicates();

        Assert.assertEquals(testInput, expectedOutput);
        Assert.assertArrayEquals(testInput.toArray(), expectedOutput.toArray());
    }

    @Test
    public void isPalindrome() {
        DoublyLinkedList<Integer> oddPalindrome = getTestInputForOddPalindrome();
        DoublyLinkedList<Integer> evenPalindrome = getTestInputForEvenPalindrome();
        DoublyLinkedList<Integer> nonPalindrome = getTestInput();

        Assert.assertTrue(evenPalindrome.isPalindrome());
        Assert.assertTrue(oddPalindrome.isPalindrome());
        Assert.assertFalse(nonPalindrome.isPalindrome());
    }

    @Test
    public void deleteMiddleNode() {
        DoublyLinkedList<Integer> testInput = getTestInput();
        DoublyLinkedList<Integer> expectedOutput = getExpectedOutputWithTheMiddleElementRemoved();

        testInput.removeMiddleElement();

        Assert.assertEquals(testInput, expectedOutput);
        Assert.assertArrayEquals(testInput.toArray(), expectedOutput.toArray());
    }

    @Test
    public void findKthToLast() {
        DoublyLinkedList<Integer> testInput = getTestInput();

        Assert.assertEquals(testInput.nthToLast(3), Integer.valueOf(3));
        Assert.assertEquals(testInput.nthToLast(4), Integer.valueOf(4));
        Assert.assertEquals(testInput.nthToLast(8), Integer.valueOf(1));
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