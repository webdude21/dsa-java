package eu.webdude.dsa.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BinaryTreeTests {

  @Test
  void buildBinaryTree_forEachTraversal_inOrder_shouldWorkCorrectly() {
    // Arrange
    var binaryTree =
      new BinaryTree<>("*",
        new BinaryTree<>("+",
          new BinaryTree<>("3"),
          new BinaryTree<>("2")),
        new BinaryTree<>("-",
          new BinaryTree<>("9"),
          new BinaryTree<>("6")));

    // Act
    List<String> nodes = new ArrayList<>();
    binaryTree.eachInOrder(nodes::add);
    var actualResult = new String[nodes.size()];
    for (var i = 0; i < nodes.size(); i++) {
      actualResult[i] = nodes.get(i);
    }

    // Assert
    var expectedNodes = new String[]{"3", "+", "2", "*", "9", "-", "6"};
    Assertions.assertArrayEquals(expectedNodes, actualResult);
  }

  @Test
  void buildBinaryTree_forEachTraversal_postOrder_shouldWorkCorrectly() {
    // Arrange
    var binaryTree =
      new BinaryTree<>("*",
        new BinaryTree<>("+",
          new BinaryTree<>("3"),
          new BinaryTree<>("2")),
        new BinaryTree<>("-",
          new BinaryTree<>("9"),
          new BinaryTree<>("6")));

    // Act
    List<String> nodes = new ArrayList<>();
    binaryTree.eachPostOrder(nodes::add);
    var actualResult = new String[nodes.size()];
    for (var i = 0; i < nodes.size(); i++) {
      actualResult[i] = nodes.get(i);
    }

    // Assert
    var expectedNodes = new String[]{"3", "2", "+", "9", "6", "-", "*"};
    Assertions.assertArrayEquals(expectedNodes, actualResult);
  }

  @Test
  void buildBinaryTree_printIndentedPreOrder_shouldWorkCorrectly() {
    // Arrange
    var binaryTree =
      new BinaryTree<>("*",
        new BinaryTree<>("-",
          new BinaryTree<>("+",
            new BinaryTree<>("3"),
            new BinaryTree<>("2")),
          new BinaryTree<>("*",
            new BinaryTree<>("9"),
            new BinaryTree<>("6"))),
        new BinaryTree<>("8"));

    // Act
    var output = binaryTree.printIndentedPreOrder(0, new StringBuilder());

    // Assert
    var expectedOutput = "*\n  -\n    +\n      3\n      2\n    *\n      9\n      6\n  8\n";
    Assertions.assertEquals(expectedOutput, output);
  }
}
