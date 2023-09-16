package treeDataStructure;

import java.util.List;

public class BinaryTree {

    public Node root;

    public BinaryTree() {
    }

    public BinaryTree(int rootValue) {
        root = new Node(rootValue);
    }
    public void preorderTraversal(Node node, List<Integer> traversal) {
        if (node != null) {
            traversal.add(node.getValue());
            preorderTraversal(node.getLiftChild(), traversal);
            preorderTraversal(node.getRightChild(), traversal);
        }
    }

    public void inorderTraversal(Node node, List<Integer> traversal) {
        if (node != null) {
            inorderTraversal(node.getLiftChild(), traversal);
            traversal.add(node.getValue());
            inorderTraversal(node.getRightChild(), traversal);
        }
    }

    public void postorderTraversal(Node node, List<Integer> traversal) {
        if (node != null) {
            postorderTraversal(node.getLiftChild(), traversal);
            postorderTraversal(node.getRightChild(), traversal);
            traversal.add(node.getValue());
        }
    }
}
