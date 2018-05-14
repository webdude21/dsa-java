package eu.webdude.dsa.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BinarySearchTreeTests {

  private BinarySearchTree<Integer> bst;

  @Test
  void createBinaryTree_testStructure_leftSubTree() {
    var root = bst.getRoot();

    Assertions.assertEquals(Integer.valueOf(12), root.getValue());

    var left = root.getLeft();

    Assertions.assertEquals(Integer.valueOf(5), left.getValue());

    var left_left = left.getLeft();
    var left_right = left.getRight();

    Assertions.assertEquals(Integer.valueOf(1), left_left.getValue());
    Assertions.assertEquals(Integer.valueOf(8), left_right.getValue());
  }

  @Test
  void createBinaryTree_testStructure_rightSubTree() {
    var root = bst.getRoot();

    Assertions.assertEquals(Integer.valueOf(12), root.getValue());

    var right = root.getRight();

    Assertions.assertEquals(Integer.valueOf(21), right.getValue());

    var right_left = right.getLeft();
    var right_right = right.getRight();

    Assertions.assertEquals(Integer.valueOf(18), right_left.getValue());
    Assertions.assertEquals(Integer.valueOf(23), right_right.getValue());
  }

  @Test
  void testContainsMethod_shouldReturnFalse() {
    var contains = bst.contains(-10);
    Assertions.assertFalse(contains);
  }

  @Test
  void testContainsMethod_shouldReturnTrue() {
    var contains = bst.contains(5);
    Assertions.assertTrue(contains);
  }

  @Test
  void testSearch_CheckReturnedTreeStructure1() {
    var search = bst.search(5);

    var root = search.getRoot();
    Assertions.assertEquals(Integer.valueOf(5), root.getValue());

    var left = root.getLeft();
    var right = root.getRight();

    Assertions.assertEquals(Integer.valueOf(1), left.getValue());
    Assertions.assertEquals(Integer.valueOf(8), right.getValue());
  }

  @Test
  void testSearch_CheckReturnedTreeStructure2() {
    bst.insert(50);
    bst.insert(100);
    bst.insert(75);
    bst.insert(60);

    var search = bst.search(23);

    var root = search.getRoot();
    Assertions.assertEquals(Integer.valueOf(23), root.getValue());

    var left = root.getLeft();
    var right = root.getRight();

    Assertions.assertNull(left);
    Assertions.assertEquals(Integer.valueOf(50), right.getValue());

    var right_left = right.getLeft();
    var right_right = right.getRight();

    Assertions.assertNull(right_left);
    Assertions.assertEquals(Integer.valueOf(100), right_right.getValue());

    var right_right_left = right_right.getLeft();
    var right_right_right = right_right.getRight();

    Assertions.assertEquals(Integer.valueOf(75), right_right_left.getValue());
    Assertions.assertNull(right_right_right);

    var right_right_left_left = right_right_left.getLeft();
    Assertions.assertEquals(Integer.valueOf(60), right_right_left_left.getValue());
  }

  @Test
  void testRange_getAllNodes() {
    var range = bst.range(0, 100);

    var values = new Integer[]{1, 5, 8, 12, 18, 21, 23};
    var index = 0;
    for (var integer : range) {
      Assertions.assertEquals(values[index++], integer);
    }
  }

  @Test
  void testRange_shouldNotFindAnyNodes() {
    var range = bst.range(-1, -1);

    List<Integer> foundValues = new ArrayList<>();
    for (var value : range) {
      foundValues.add(value);
    }

    Assertions.assertEquals(0, foundValues.size());
  }

  @Test
  void testRange_shouldFindOnlyOneElement() {
    var range = bst.range(12, 12);

    var index = 0;
    var values = new Integer[]{12};
    for (var value : range) {
      Assertions.assertEquals(values[index], value);
    }
  }

  @Test
  void testRange_shouldFindNodes() {
    var range = bst.range(5, 18);

    var index = 0;
    var values = new Integer[]{5, 8, 12, 18};
    for (var value : range) {
      Assertions.assertEquals(values[index++], value);
    }

    Assertions.assertEquals(index, values.length);
  }

  @BeforeEach
  void setUp() {
    bst = new BinarySearchTree<>();

    bst.insert(12);
    bst.insert(21);
    bst.insert(5);
    bst.insert(1);
    bst.insert(8);
    bst.insert(18);
    bst.insert(23);
  }
}
