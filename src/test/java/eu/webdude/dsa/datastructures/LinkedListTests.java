package eu.webdude.dsa.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListTests {

    @Test
    void addFirstShouldIncreaseCount() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(1);

        Assertions.assertEquals(1, list.size());
    }

    @Test
    void addLastShouldIncreaseCount() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addLast(1);

        Assertions.assertEquals(1, list.size());
    }

    @Test
    void addFirstShouldAddElement() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(1);

        for (Integer item : list) {
            Assertions.assertEquals(Integer.valueOf(1), item);
        }
    }

    @Test
    void AddLastShouldAddElement() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addLast(1);

        for (Integer item : list) {
            Assertions.assertEquals(Integer.valueOf(1), item);
        }
    }

    @Test
    void addFirstMultipleElementsShouldAddElement() {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.addFirst(i);
        }

        int expected = 0;
        for (Integer item : list) {
            expected++;
        }
        Assertions.assertEquals(expected, list.size());
    }

    @Test
    void addLastMultipleElementsShouldAddElement() {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }

        int expected = 0;

        for (Integer item : list) {
            expected++;
        }

        Assertions.assertEquals(expected, list.size());
    }

    @Test
    void removeFirstSingleElementShouldDecreaseCount() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.removeFirst();

        Assertions.assertEquals(1, list.size());
    }

    @Test
    void RemoveLastSingleElementShouldDecreaseCount() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.removeLast();

        Assertions.assertEquals(1, list.size());
    }

    @Test
    void RemoveFirstMultipleElementsShouldRemove() {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }

        for (Integer i = 0; i < 100; i++) {
            Assertions.assertEquals(i, list.removeFirst());
        }

        Assertions.assertEquals(0, list.size());
    }

    @Test
    void RemoveLastMultipleElementsShouldRemove() {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.addFirst(i);
        }

        for (Integer i = 0; i < 100; i++) {
            Assertions.assertEquals(i, list.removeLast());
        }

        Assertions.assertEquals(0, list.size());
    }
}
