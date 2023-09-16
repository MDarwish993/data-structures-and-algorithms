package treeDataStructure;

public class BinarySearchTree extends BinaryTree{
    public BinarySearchTree(int rootValue) {
        super(rootValue);
    }

    public BinarySearchTree() {
    }

    public void add(int value) {
        root = insert(root, value);
    }

    private Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.getValue()) {
            root.setLiftChild(insert(root.getLiftChild(), value))  ;
        } else if (value > root.getValue()) {
            root.setRightChild(insert(root.getRightChild(), value));
        }

        return root;
    }

    public boolean contains(int value) {
        return search(root, value);
    }

    private boolean search(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (root.getValue() == value) {
            return true;
        }

        if (value < root.getValue()) {
            return search(root.getLiftChild(), value);
        } else {
            return search(root.getRightChild(), value);
        }
    }
}
