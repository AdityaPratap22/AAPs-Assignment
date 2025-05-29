class Node {
    int val;
    Node left, right;

    public Node(int key) {
        val = key;
        left = right = null;
    }
}

public class BST {
    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.val) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }
    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = null;
        int[] values = {5, 3, 7, 2, 4, 6, 8};
        for (int val : values) {
            root = insert(root, val);
        }
        inorder(root);
        System.out.println();
    }
}
