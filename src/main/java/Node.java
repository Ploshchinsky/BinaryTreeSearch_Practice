import java.util.List;

public class Node implements Comparable<Node> {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node(int[] arr) {
        Node cursor = this;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                cursor.setData(arr[i]);
                continue;
            }
            cursor.add(new Node(arr[i]));
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    private Node getLeft() {
        return left;
    }

    private void setLeft(Node left) {
        this.left = left;
    }

    private Node getRight() {
        return right;
    }

    private void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int compareTo(Node anotherNode) {
        return this.data - anotherNode.data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public void add(Node node) {
        Node cursor = this;
        while (true) {
            if (node.getData() < cursor.getData()) {
                if (cursor.getLeft() == null) {
                    cursor.setLeft(node);
                    return;
                }
                cursor = cursor.getLeft();
            } else {
                if (cursor.getRight() == null) {
                    cursor.setRight(node);
                    return;
                }
                cursor = cursor.getRight();
            }
        }
    }

    public boolean contain(Node node) {
        Node cursor = this;
        while (true) {
            if (cursor == node) {
                return true;
            }
            if (node.data < cursor.data) {
                if (cursor.getLeft() != null) {
                    cursor = cursor.getLeft();
                } else {
                    return false;
                }
            } else {
                if (cursor.getRight() != null) {
                    cursor = cursor.getRight();
                } else {
                    return false;
                }
            }
        }
    }

    public boolean contain(int data) {
        Node cursor = this;
        while (true) {
            if (cursor.getData() == data) {
                return true;
            }
            if (data < cursor.getData()) {
                if (cursor.getLeft() != null) {
                    cursor = cursor.getLeft();
                } else {
                    return false;
                }
            } else {
                if (cursor.getRight() != null) {
                    cursor = cursor.getRight();
                } else {
                    return false;
                }
            }
        }
    }

    public static void showTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        showTree(root.getLeft());
        showTree(root.getRight());
    }

    public static List<Node> getList(Node root, List<Node> accum) {
        if (root == null) {
            return accum;
        }
        accum.add(root);
        getList(root.getLeft(), accum);
        getList(root.getRight(), accum);
        return accum;
    }

    public static List<Node> naturalOrderTree(Node root, List<Node> accum) {
        if (root == null) {
            return accum;
        }
        naturalOrderTree(root.getLeft(), accum);
        accum.add(root);
        naturalOrderTree(root.getRight(), accum);
        return accum;
    }
}
