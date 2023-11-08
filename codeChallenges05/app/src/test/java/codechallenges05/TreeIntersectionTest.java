package codechallenges05;

import org.junit.jupiter.api.Test;
import treeDataStructure.Node;
import treeDataStructure.TreeIntersection;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeIntersectionTest {

    @Test
    public void testTreeIntersection() {
        // Create sample binary trees
        Node tree1 = new Node(100);
        tree1.setLiftChild(new Node(160));
        tree1.setRightChild(new Node(125));
        tree1.getLiftChild().setLiftChild(new Node(175));
        tree1.getLiftChild().setRightChild(new Node(200));

        Node tree2 = new Node(160);
        tree2.setLiftChild(new Node(350));
        tree2.setRightChild(new Node(500));
        tree2.getLiftChild().setLiftChild(new Node(125));
        tree2.getLiftChild().setRightChild(new Node(200));

        TreeIntersection solution = new TreeIntersection();
        Set<Integer> commonValues = solution.tree_intersection(tree1, tree2);

        Set<Integer> expectedCommonValues = new HashSet<>();
        expectedCommonValues.add(160);
        expectedCommonValues.add(125);
        expectedCommonValues.add(200);

        assertEquals(expectedCommonValues, commonValues);
    }

    @Test
    public void testTreeIntersectionWithEmptyTrees() {
        Node tree1 = null;
        Node tree2 = null;

        TreeIntersection solution = new TreeIntersection();
        Set<Integer> commonValues = solution.tree_intersection(tree1, tree2);

        Set<Integer> expectedCommonValues = new HashSet<>();
        assertEquals(expectedCommonValues, commonValues);
    }

    @Test
    public void testTreeIntersectionWithDifferentTrees() {
        // Create sample binary trees
        Node tree1 = new Node(100);
        tree1.setLiftChild(new Node(160));
        tree1.setRightChild(new Node(125));
        tree1.getLiftChild().setLiftChild(new Node(175));
        tree1.getLiftChild().setRightChild(new Node(200));

        Node tree2 = new Node(350);
        tree2.setLiftChild(new Node(500));

        TreeIntersection solution = new TreeIntersection();
        Set<Integer> commonValues = solution.tree_intersection(tree1, tree2);

        Set<Integer> expectedCommonValues = new HashSet<>();
        assertEquals(expectedCommonValues, commonValues);
    }
}
