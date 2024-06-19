import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NodeTest {
    static int[] arr1 = {15, 8, 19, 10, 21, 4, 0, 12};
    static int[] arr2 = {45, 22, 39, 57, 49, 12, 70};
    static int[] searchElements = {28, 13, 0, 3, 12, -5, 999, 70, 10};
    static Node root1, root2;

    @BeforeAll
    public static void nodeInit() {
        for (int i = 0; i < arr1.length; i++) {
            if (i == 0) {
                root1 = new Node(arr1[i]);
                continue;
            }
            root1.add(new Node(arr1[i]));
        }

        for (int i = 0; i < arr2.length; i++) {
            if (i == 0) {
                root2 = new Node(arr2[i]);
                continue;
            }
            root2.add(new Node(arr2[i]));
        }
    }

    @Test
    public void test1() {
        int expectedMatches = 4;
        int actualMatches = 0;

        for (int element : searchElements) {
            if (root1.contain(element) || root2.contain(element)) {
                actualMatches++;
            }
        }
        Assertions.assertEquals(expectedMatches, actualMatches);
    }

    @Test
    public void test2() {
        List<Node> expected = Node.getList(root1, new ArrayList<>());
        expected.sort(Node::compareTo);
        List<Node> actual = Node.naturalOrderTree(root1, new ArrayList<>());
        Assertions.assertEquals(expected, actual);

        expected = Node.getList(root2, new ArrayList<>());
        expected.sort(Node::compareTo);
        actual = Node.naturalOrderTree(root2, new ArrayList<>());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        Node tree = new Node(arr1);
        Node.showTree(tree);
        System.out.println("---");
        List<Node> sortedTree = Node.naturalOrderTree(tree, new ArrayList<>());
        sortedTree.forEach(System.out::println);
    }
}
