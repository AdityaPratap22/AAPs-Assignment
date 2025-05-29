#include <iostream>
using namespace std;

class Node {
public:
    int data;
    Node* left;
    Node* right;

    Node(int item) {
        data = item;
        left = right = nullptr;
    }
};

class BinaryTree {
public:
    Node* root;

    BinaryTree() {
        root = nullptr;
    }

    Node* insert(Node* node, int data) {
        if (node == nullptr) {
            return new Node(data);
        }

        if (data < node->data) {
            node->left = insert(node->left, data);
        } else {
            node->right = insert(node->right, data);
        }

        return node;
    }

    void inorder(Node* node) {
        if (node != nullptr) {
            inorder(node->left);
            cout << node->data << " ";
            inorder(node->right);
        }
    }

    void mirror(Node* node) {
        if (node == nullptr)
            return;

        mirror(node->left);
        mirror(node->right);

        // Swap the left and right children
        Node* temp = node->left;
        node->left = node->right;
        node->right = temp;
    }
};

int main() {
    BinaryTree tree;

    // Sample insertions
    tree.root = tree.insert(tree.root, 50);
    tree.insert(tree.root, 30);
    tree.insert(tree.root, 70);
    tree.insert(tree.root, 20);
    tree.insert(tree.root, 40);
    tree.insert(tree.root, 60);
    tree.insert(tree.root, 80);

    cout << "Inorder traversal of the original tree:\n";
    tree.inorder(tree.root);
    cout << endl;

    tree.mirror(tree.root);

    cout << "Inorder traversal of the mirrored tree:\n";
    tree.inorder(tree.root);
    cout << endl;

    return 0;
}
