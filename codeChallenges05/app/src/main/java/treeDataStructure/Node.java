package treeDataStructure;

public class Node {
    private int value;
    private Node liftChild;
    private Node rightChild;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLiftChild() {
        return liftChild;
    }

    public void setLiftChild(Node liftChild) {
        this.liftChild = liftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node(int value) {
        this.value = value;
        this.liftChild = null;
        this.rightChild = null;
    }
}
