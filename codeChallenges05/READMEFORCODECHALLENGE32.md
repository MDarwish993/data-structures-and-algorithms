# Challenge 32
#### Find common values in 2 binary trees.
## Picture of whiteboard
<img src="C:\Users\C-ROAD\IdeaProjects\data-structures-and-algorithms\codeChallenges05\app\src\assets\cc32.jpg "/>

### - Initial findFirstRepeatedWord Method:
- Arguments:  2 binary trees.
- Return: array of common values.
## Solution
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