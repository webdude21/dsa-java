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
        BinarySearchTree<Integer>.Node root = bst.getRoot();

        Assertions.assertEquals(Integer.valueOf(12), root.getValue());

        BinarySearchTree<Integer>.Node left = root.getLeft();

        Assertions.assertEquals(Integer.valueOf(5), left.getValue());

        BinarySearchTree<Integer>.Node left_left = left.getLeft();
        BinarySearchTree<Integer>.Node left_right = left.getRight();

        Assertions.assertEquals(Integer.valueOf(1), left_left.getValue());
        Assertions.assertEquals(Integer.valueOf(8), left_right.getValue());
    }

    @Test
    void createBinaryTree_testStructure_rightSubTree() {
        BinarySearchTree<Integer>.Node root = bst.getRoot();

        Assertions.assertEquals(Integer.valueOf(12), root.getValue());

        BinarySearchTree<Integer>.Node right = root.getRight();

        Assertions.assertEquals(Integer.valueOf(21), right.getValue());

        BinarySearchTree<Integer>.Node right_left = right.getLeft();
        BinarySearchTree<Integer>.Node right_right = right.getRight();

        Assertions.assertEquals(Integer.valueOf(18), right_left.getValue());
        Assertions.assertEquals(Integer.valueOf(23), right_right.getValue());
    }

    @Test
    void testContainsMethod_shouldReturnFalse() {
        boolean contains = bst.contains(-10);
        Assertions.assertEquals(false, contains);
    }

    @Test
    void testContainsMethod_shouldReturnTrue() {
        boolean contains = bst.contains(5);
        Assertions.assertEquals(true, contains);
    }

    @Test
    void testSearch_CheckReturnedTreeStructure1() {
        BinarySearchTree<Integer> search = bst.search(5);

        BinarySearchTree<Integer>.Node root = search.getRoot();
        Assertions.assertEquals(Integer.valueOf(5), root.getValue());

        BinarySearchTree<Integer>.Node left = root.getLeft();
        BinarySearchTree<Integer>.Node right = root.getRight();

        Assertions.assertEquals(Integer.valueOf(1), left.getValue());
        Assertions.assertEquals(Integer.valueOf(8), right.getValue());
    }

    @Test
    void testSearch_CheckReturnedTreeStructure2() {
        bst.insert(50);
        bst.insert(100);
        bst.insert(75);
        bst.insert(60);

        BinarySearchTree<Integer> search = bst.search(23);

        BinarySearchTree<Integer>.Node root = search.getRoot();
        Assertions.assertEquals(Integer.valueOf(23), root.getValue());

        BinarySearchTree<Integer>.Node left = root.getLeft();
        BinarySearchTree<Integer>.Node right = root.getRight();

        Assertions.assertEquals(null, left);
        Assertions.assertEquals(Integer.valueOf(50), right.getValue());

        BinarySearchTree<Integer>.Node right_left = right.getLeft();
        BinarySearchTree<Integer>.Node right_right = right.getRight();

        Assertions.assertEquals(null, right_left);
        Assertions.assertEquals(Integer.valueOf(100), right_right.getValue());

        BinarySearchTree<Integer>.Node right_right_left = right_right.getLeft();
        BinarySearchTree<Integer>.Node right_right_right = right_right.getRight();

        Assertions.assertEquals(Integer.valueOf(75), right_right_left.getValue());
        Assertions.assertEquals(null, right_right_right);

        BinarySearchTree<Integer>.Node right_right_left_left = right_right_left.getLeft();
        Assertions.assertEquals(Integer.valueOf(60), right_right_left_left.getValue());
    }

    @Test
    void testRange_getAllNodes() {
        Iterable<Integer> range = bst.range(0, 100);

        Integer[] values = new Integer[]{1, 5, 8, 12, 18, 21, 23};
        int index = 0;
        for (Integer integer : range) {
            Assertions.assertEquals(values[index++], integer);
        }
    }

    @Test
    void testRange_shouldNotFindAnyNodes() {
        Iterable<Integer> range = bst.range(-1, -1);

        List<Integer> foundValues = new ArrayList<>();
        for (Integer value : range) {
            foundValues.add(value);
        }

        Assertions.assertEquals(0, foundValues.size());
    }

    @Test
    void testRange_shouldFindOnlyOneElement() {
        Iterable<Integer> range = bst.range(12, 12);

        int index = 0;
        Integer[] values = new Integer[]{12};
        for (Integer value : range) {
            Assertions.assertEquals(values[index], value);
        }
    }

    @Test
    void testRange_shouldFindNodes() {
        Iterable<Integer> range = bst.range(5, 18);

        int index = 0;
        Integer[] values = new Integer[]{5, 8, 12, 18};
        for (Integer value : range) {
            Assertions.assertEquals(values[index++], value);
        }
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
