package eu.webdude.dsa;

import com.sun.deploy.util.StringUtils;
import eu.webdude.dsa.datastructures.BinaryTree;
import eu.webdude.dsa.datastructures.Tree;

import java.util.stream.Collectors;

public class PlayWithTree {

    public static void main(String[] args) {
        Tree<Integer> tree =
                new Tree<>(7,
                        new Tree<>(19,
                                new Tree<>(1),
                                new Tree<>(12),
                                new Tree<>(31)),
                        new Tree<>(21),
                        new Tree<>(14,
                                new Tree<>(23),
                                new Tree<>(6)));

        System.out.println("Tree (indented):");
        String output = tree.print(0, new StringBuilder());
        System.out.println(output);

        System.out.printf("Root Node is: %s%n", tree.getRoot().getValue());
        System.out.printf("Leaf nodes are: %s%n", StringUtils.join(tree.getLeafs()
                .stream()
                .map(Tree::getValue)
                .map(Object::toString)
                .collect(Collectors.toList()), ", "));

        System.out.println("Tree nodes:");
        tree.each(e -> System.out.print(" " + e));
        System.out.println();

        System.out.println();
        BinaryTree<String> binaryTree =
                new BinaryTree<>("*",
                        new BinaryTree<>("+",
                                new BinaryTree<>("3"),
                                new BinaryTree<>("2")),
                        new BinaryTree<>("-",
                                new BinaryTree<>("9"),
                                new BinaryTree<>("6")));

        System.out.println("Binary tree (indented, pre-order):");
        output = binaryTree.printIndentedPreOrder(0, new StringBuilder());
        System.out.println(output);

        System.out.println("Binary tree nodes (in-order):");
        binaryTree.eachInOrder(e -> System.out.print(" " + e));
        System.out.println();

        System.out.println("Binary tree nodes (post-order):");
        binaryTree.eachPostOrder(e -> System.out.print(" " + e));
        System.out.println();
    }
}
