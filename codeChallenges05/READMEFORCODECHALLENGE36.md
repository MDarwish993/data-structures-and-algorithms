# Challenge 36
#### Implement a breadth-first traversal on a graph.
## Picture of whiteboard
<img src="C:\Users\C-ROAD\IdeaProjects\data-structures-and-algorithms\codeChallenges05\app\src\assets\cc36.jpg "/>

### - Initial breadthFirst Method:
- Arguments:   Graph structure and a starting node.
- Return: Ordered collection of visited nodes.
## Solution
public List<Vertex<T>> breadthFirst(Vertex<T> start) {
List<Vertex<T>> visitedNodes = new ArrayList<>();
if (start == null || !adjacencyLists.containsKey(start)) {
return visitedNodes;
}

        Queue<Vertex<T>> queue = new LinkedList<>();
        HashMap<Vertex<T>, Boolean> visited = new HashMap<>();

        queue.add(start);
        visited.put(start, true);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            visitedNodes.add(current);

            for (Edge<T> neighborEdge : adjacencyLists.get(current)) {
                Vertex<T> neighbor = neighborEdge.destination;
                if (!visited.containsKey(neighbor) || !visited.get(neighbor)) {
                    visited.put(neighbor, true);
                    queue.add(neighbor);
                }
            }
        }

        return visitedNodes;
    }