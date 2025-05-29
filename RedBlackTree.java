import java.util.*;

class Node {
    int data;
    boolean color; 
    Node left, right, parent;

    Node(int data) {
        this.data = data;
        this.color = true; 
        this.left = this.right = this.parent = null;
    }
}

public class RedBlackTree {
    private final Node NULL_NODE;
    private Node root;

    public RedBlackTree() {
        NULL_NODE = new Node(0);
        NULL_NODE.color = false; // 
        NULL_NODE.left = NULL_NODE.right = null;
        root = NULL_NODE;
    }

    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != NULL_NODE) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != NULL_NODE) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    private void fixInsert(Node k) {
        while (k.parent != null && k.parent.color) { 
            if (k.parent == k.parent.parent.right) {
                Node u = k.parent.parent.left; 
                if (u != null && u.color) { 
                    u.color = false;
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rotateRight(k);
                    }
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    rotateLeft(k.parent.parent);
                }
            } else {
                Node u = k.parent.parent.right; 
                if (u != null && u.color) {
                    u.color = false;
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        rotateLeft(k);
                    }
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    rotateRight(k.parent.parent);
                }
            }
            if (k == root) break;
        }
        root.color = false;
    }

    public void insert(int data) {
        Node node = new Node(data);
        node.left = node.right = NULL_NODE;

        Node parent = null;
        Node current = root;

        while (current != NULL_NODE) {
            parent = current;
            if (node.data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        node.parent = parent;
        if (parent == null) {
            root = node;
        } else if (node.data < parent.data) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        if (node.parent == null) {
            node.color = false; 
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        fixInsert(node);
    }

    public void inorder(Node node) {
        if (node != NULL_NODE) {
            inorder(node.left);
            System.out.print(node.data + (node.color ? " (Red) " : " (Black) "));
            inorder(node.right);
        }
    }

    public Node getRoot() {
        return root;
    }

    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        int[] values = {10, 20, 30, 15, 25, 5};

        for (int val : values) {
            rbt.insert(val);
        }

        System.out.print("Inorder traversal with node colors: ");
        rbt.inorder(rbt.getRoot());
        System.out.println();
    }
}
