package treeDataStructure;

import java.util.HashSet;
import java.util.Set;

public class TreeIntersection {
    public Set<Integer> tree_intersection(Node tree1, Node tree2) {
        Set<Integer> values1 = new HashSet<>();
        Set<Integer> commonValues = new HashSet<>();

        populateSet(tree1, values1);
        findCommonValues(tree2, values1, commonValues);

        return commonValues;
    }

    private void populateSet(Node node, Set<Integer> set) {
        if (node == null) return;

        set.add(node.getValue());
        populateSet(node.getLiftChild(), set);
        populateSet(node.getRightChild(), set);
    }

    private void findCommonValues(Node node, Set<Integer> set, Set<Integer> commonValues) {
        if (node == null) return;

        if (set.contains(node.getValue())) {
            commonValues.add(node.getValue());
        }

        findCommonValues(node.getLiftChild(), set, commonValues);
        findCommonValues(node.getRightChild(), set, commonValues);
    }
}
