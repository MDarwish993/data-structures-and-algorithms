package codechallenges05;

import org.junit.jupiter.api.Test;
import treeDataStructure.BinarySearchTree;
import treeDataStructure.BinaryTree;
import treeDataStructure.Node;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    @Test
    public void testEmptyTree() {
        BinarySearchTree bst= new BinarySearchTree();
        assertNull(bst.root);
    }

    @Test
    public void testSingleRootNode() {
        BinarySearchTree bst= new BinarySearchTree(10);
        assertEquals(10, bst.root.getValue());
        assertNull(bst.root.getLiftChild());
        assertNull(bst.root.getRightChild());
    }

    @Test
    public void testAddLeftAndRightChild() {
        BinarySearchTree bst= new BinarySearchTree(10);
        bst.add(5);
        bst.add(15);

        assertEquals(10, bst.root.getValue());
        assertEquals(5, bst.root.getLiftChild().getValue());
        assertEquals(15, bst.root.getRightChild().getValue());
    }

    @Test
    public void testPreorderTraversal() {
        BinarySearchTree bst= new BinarySearchTree(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);

        List<Integer> expectedPreorder = new ArrayList<>();
        expectedPreorder.add(10);
        expectedPreorder.add(5);
        expectedPreorder.add(3);
        expectedPreorder.add(7);
        expectedPreorder.add(15);

        List<Integer> preorder = new ArrayList<>();
        bst.preorderTraversal(bst.root, preorder);
        assertEquals(expectedPreorder, preorder);
    }

    @Test
    public void testInorderTraversal() {
        BinarySearchTree bst= new BinarySearchTree(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);

        List<Integer> expectedInorder = new ArrayList<>();
        expectedInorder.add(3);
        expectedInorder.add(5);
        expectedInorder.add(7);
        expectedInorder.add(10);
        expectedInorder.add(15);

        List<Integer> inorder = new ArrayList<>();
        bst.inorderTraversal(bst.root, inorder);
        assertEquals(expectedInorder, inorder);
    }

    @Test
    public void testPostorderTraversal() {
        BinarySearchTree bst= new BinarySearchTree(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);

        List<Integer> expectedPostorder = new ArrayList<>();
        expectedPostorder.add(3);
        expectedPostorder.add(7);
        expectedPostorder.add(5);
        expectedPostorder.add(15);
        expectedPostorder.add(10);

        List<Integer> postorder = new ArrayList<>();
        bst.postorderTraversal(bst.root, postorder);
        assertEquals(expectedPostorder, postorder);
    }

    @Test
    public void testContainsExistingValue() {
        BinarySearchTree bst= new BinarySearchTree(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);

        assertTrue(bst.contains(7));
    }

    @Test
    public void testContainsNonExistingValue() {
        BinarySearchTree bst= new BinarySearchTree(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);

        assertFalse(bst.contains(12));
    }



    @Test
    public void testSingleNodeTree() {
        BinaryTree singleNodeTree = new BinaryTree();
        singleNodeTree.root = new Node(20);
        int max = singleNodeTree.findMax();
        assertEquals(20, max);
    }

    @Test
    public void testMultipleNodeTree() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(2);
        tree.root.setLiftChild(new Node(7));
        tree.root.setRightChild(new Node(5));
        tree.root.getLiftChild().setLiftChild(new Node(2));
        tree.root.getLiftChild().setRightChild(new Node(6));
        tree.root.getRightChild().setRightChild(new Node(9));
        tree.root.getLiftChild().getRightChild().setLiftChild(new Node(5));
        tree.root.getLiftChild().getRightChild().setRightChild(new Node(11));
        tree.root.getRightChild().getRightChild().setLiftChild(new Node(4));
        int max = tree.findMax();
        assertEquals(11, max);
    }



    @Test
    public void testMultipleNodeTreeBreadthFirstMethod() {
        BinaryTree tree = new BinaryTree(2);

        tree.root.setLiftChild(new Node(7));
        tree.root.setRightChild(new Node(5)) ;
        tree.root.getLiftChild().setLiftChild(new Node(2)) ;
        tree.root.getLiftChild().setRightChild(new Node(6));
        tree.root.getRightChild().setRightChild(new Node(9));
        tree.root.getLiftChild().getRightChild().setLiftChild(new Node(5));
        tree.root.getLiftChild().getRightChild().setRightChild(new Node(11));
        tree.root.getRightChild().getRightChild().setLiftChild(new Node(4));

        List<Integer> result = tree.breadthFirst();

        assertEquals(9, result.size());
        assertEquals(Integer.valueOf(2), result.get(0));
        assertEquals(Integer.valueOf(7), result.get(1));
        assertEquals(Integer.valueOf(5), result.get(2));
        assertEquals(Integer.valueOf(2), result.get(3));
        assertEquals(Integer.valueOf(6), result.get(4));
        assertEquals(Integer.valueOf(9), result.get(5));
        assertEquals(Integer.valueOf(5), result.get(6));
        assertEquals(Integer.valueOf(11), result.get(7));
        assertEquals(Integer.valueOf(4), result.get(8));

    }
}
