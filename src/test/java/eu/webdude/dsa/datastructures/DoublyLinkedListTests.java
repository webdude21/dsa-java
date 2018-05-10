package eu.webdude.dsa.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DoublyLinkedListTests {

  @Test
  void addFirst_emptyList_shouldAddElement() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    list.addFirst(5);
    var expectedSize = 1;
    Assertions.assertEquals(expectedSize, list.size());

    List<Integer> items = new ArrayList<>();
    for (var integer : list) {
      items.add(integer);
    }

    var expectedArray = new int[]{5};
    var array = items.stream().mapToInt(i -> i).toArray();
    Assertions.assertArrayEquals(expectedArray, array);
  }


  @Test
  void addFirst_severalElements_shouldAddElementsCorrectly() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    list.addFirst(10);
    list.addFirst(5);
    list.addFirst(3);

    var expectedSize = 3;
    Assertions.assertEquals(expectedSize, list.size());

    List<Integer> items = new ArrayList<>();
    for (var integer : list) {
      items.add(integer);
    }

    var expectedArray = new int[]{3, 5, 10};
    var array = items.stream().mapToInt(i -> i).toArray();
    Assertions.assertArrayEquals(expectedArray, array);
  }

  @Test
  void addLast_emptyList_shouldAddElement() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    list.addLast(5);
    var expectedSize = 1;
    Assertions.assertEquals(expectedSize, list.size());

    List<Integer> items = new ArrayList<>();
    for (var integer : list) {
      items.add(integer);
    }

    var expectedArray = new int[]{5};
    var array = items.stream().mapToInt(i -> i).toArray();
    Assertions.assertArrayEquals(expectedArray, array);
  }

  @Test
  void addLast_severalElements_shouldAddElementsCorrectly() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    list.addLast(5);
    list.addLast(10);
    list.addLast(15);

    var expectedSize = 3;
    Assertions.assertEquals(expectedSize, list.size());

    List<Integer> items = new ArrayList<>();
    for (var integer : list) {
      items.add(integer);
    }

    var expectedArray = new int[]{5, 10, 15};
    var array = items.stream().mapToInt(i -> i).toArray();
    Assertions.assertArrayEquals(expectedArray, array);
  }

  @Test
  void removeFirst_oneElement_shouldMakeListEmpty() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    list.addLast(5);

    int element = list.removeFirst();

    var expectedElement = 5;
    var expectedSize = 0;
    Assertions.assertEquals(expectedElement, element);
    Assertions.assertEquals(expectedSize, list.size());

    List<Integer> items = new ArrayList<>();
    list.forEach(items::add);

    var expectedArray = new int[]{};
    var array = items.stream().mapToInt(i -> i).toArray();
    Assertions.assertArrayEquals(expectedArray, array);
  }


  @Test
  void removeFirst_emptyList_shouldThrowException() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
    assertThrows(IllegalArgumentException.class, list::removeFirst);
  }

  @Test
  void removeFirst_severalElements_shouldRemoveElementsCorrectly() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    list.addLast(5);
    list.addLast(6);
    list.addLast(7);

    int element = list.removeFirst();

    var expectedElement = 5;
    var expectedSize = 2;
    Assertions.assertEquals(expectedElement, element);
    Assertions.assertEquals(expectedSize, list.size());

    List<Integer> items = new ArrayList<>();
    for (var integer : list) {
      items.add(integer);
    }

    var expectedArray = new int[]{6, 7};
    var array = items.stream().mapToInt(i -> i).toArray();
    Assertions.assertArrayEquals(expectedArray, array);
  }


  @Test
  void removeLast_oneElement_shouldMakeListEmpty() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    list.addFirst(5);

    int element = list.removeLast();

    var expectedElement = 5;
    var expectedSize = 0;
    Assertions.assertEquals(expectedElement, element);
    Assertions.assertEquals(expectedSize, list.size());

    List<Integer> items = new ArrayList<>();
    list.forEach(items::add);

    var expectedArray = new int[]{};
    var array = items.stream().mapToInt(i -> i).toArray();
    Assertions.assertArrayEquals(expectedArray, array);
  }


  @Test
  void removeLast_emptyList_shouldThrowException() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
    assertThrows(IllegalArgumentException.class, list::removeFirst);
  }

  @Test
  void removeLast_severalElements_shouldRemoveElementsCorrectly() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    list.addFirst(10);
    list.addFirst(9);
    list.addFirst(8);

    int element = list.removeLast();

    var expectedElement = 10;
    var expectedSize = 2;
    Assertions.assertEquals(expectedElement, element);
    Assertions.assertEquals(expectedSize, list.size());

    List<Integer> items = new ArrayList<>();
    for (var integer : list) {
      items.add(integer);
    }

    var expectedArray = new int[]{8, 9};
    var array = items.stream().mapToInt(i -> i).toArray();
    Assertions.assertArrayEquals(expectedArray, array);
  }


  @Test
  void forEach_emptyList_shouldEnumerateElementsCorrectly() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    List<Integer> items = new ArrayList<>();
    list.forEach(items::add);

    var expectedArray = new int[]{};
    var array = items.stream().mapToInt(i -> i).toArray();
    Assertions.assertArrayEquals(expectedArray, array);
  }


  @Test
  void forEach_singleElement_shouldEnumerateElementsCorrectly() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
    list.addLast(5);

    List<Integer> items = new ArrayList<>();
    for (var integer : list) {
      items.add(integer);
    }

    var expectedArray = new int[]{5};
    var array = items.stream().mapToInt(i -> i).toArray();
    Assertions.assertArrayEquals(expectedArray, array);
  }

  @Test
  void forEach_multipleElements_shouldEnumerateElementsCorrectly() {
    DoublyLinkedList<String> list = new DoublyLinkedList<>();
    list.addLast("Five");
    list.addLast("Six");
    list.addLast("Seven");

    var expectedArray = new String[]{"Five", "Six", "Seven"};
    Object[] array = list.toArray();
    Assertions.assertArrayEquals(expectedArray, array);
  }


  @Test
  void iterable_foreach_multipleElements() {
    DoublyLinkedList<String> list = new DoublyLinkedList<>();

    list.addLast("Five");
    list.addLast("Six");
    list.addLast("Seven");

    var expectedArray = new String[]{"Five", "Six", "Seven"};
    var array = new String[expectedArray.length];
    var index = 0;
    for (var s : expectedArray) {
      array[index++] = s;
    }

    Assertions.assertArrayEquals(expectedArray, array);
  }

  @Test
  void iterable_nonGeneric_multipleElements() {
    var list = new DoublyLinkedList<>();

    list.addLast("Five");
    list.addLast(6);
    list.addLast(7.77);

    var expectedArray = new Object[]{"Five", 6, 7.77};
    var array = new Object[expectedArray.length];
    var index = 0;
    for (var o : expectedArray) {
      array[index++] = o;
    }

    Assertions.assertArrayEquals(expectedArray, array);
  }


  @Test
  void toArray_emptyList_shouldReturnEmptyArray() {
    DoublyLinkedList<String> list = new DoublyLinkedList<>();

    Object[] array = list.toArray();
    var expectedArray = new String[0];

    Assertions.assertArrayEquals(expectedArray, array);
  }


  @Test
  void toArray_nonEmptyList_shouldReturnArray() {
    DoublyLinkedList<String> list = new DoublyLinkedList<>();

    list.addLast("Five");
    list.addLast("Six");
    list.addLast("Seven");

    Object[] array = list.toArray();
    var expectedArray = new String[]{"Five", "Six", "Seven"};

    Assertions.assertArrayEquals(expectedArray, array);
  }
}
