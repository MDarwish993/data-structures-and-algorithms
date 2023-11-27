# Challenge 38
#### Conduct a depth first pre-order traversal on a graph.
## Picture of whiteboard
<img src="C:\Users\C-ROAD\IdeaProjects\data-structures-and-algorithms\codeChallenges05\app\src\assets\cc38.jpg "/>

### - Initial business trip Method:
- Arguments:   Node (Starting point of search)
- Return: A collection of nodes in their pre-order depth-first traversal order
## Solution

    public List<Vertex<T>> depthFirst(Vertex<T> start) {
        List<Vertex<T>> visitedNodes = new ArrayList<>();
        Set<Vertex<T>> visited = new HashSet<>();

        depthFirstTraversal(start, visited, visitedNodes);

        return visitedNodes;
    }

    private void depthFirstTraversal(Vertex<T> current, Set<Vertex<T>> visited, List<Vertex<T>> visitedNodes) {
        visited.add(current);
        visitedNodes.add(current);

        for (Edge<T> neighborEdge : adjacencyLists.get(current)) {
            Vertex<T> neighbor = neighborEdge.destination;
            if (!visited.contains(neighbor)) {
                depthFirstTraversal(neighbor, visited, visitedNodes);
            }
        }
    }