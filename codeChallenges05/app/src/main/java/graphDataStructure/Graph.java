package graphDataStructure;

import java.util.*;

public class Graph<T extends Comparable<? super T>> implements Comparable<Graph<T>> {
    public HashMap<Vertex<T>, LinkedList<Edge<T>>> adjacencyLists;
    private int numberOfVertices = 0;

    public Graph(int maxNumberOfVertices) {
        adjacencyLists = new HashMap<>(maxNumberOfVertices);
    }

    public Vertex<T> addVertex(T value) {
        Vertex<T> vertex = new Vertex<>(value);
        adjacencyLists.put(vertex, new LinkedList<>());
        numberOfVertices++;
        return vertex;
    }

    public void addEdge(Vertex<T> start, Vertex<T> destination) {
        addEdge(start, destination, 0);
    }

    public void addEdge(Vertex<T> start, Vertex<T> destination, int weight) {
        if (!adjacencyLists.containsKey(start) || !adjacencyLists.containsKey(destination)) {
            throw new IllegalArgumentException("both vertices must be in the inside graph");
        }

        Edge<T> edge = new Edge<>(destination, weight);
        adjacencyLists.get(start).add(edge);
    }

    public List<Vertex<T>> getVertices() {
        return new LinkedList<>(adjacencyLists.keySet());
    }

    public List<Edge<T>> getNeighbors(Vertex<T> vertex) {
        if (!adjacencyLists.containsKey(vertex)) {
            return new LinkedList<>();
        }

        return new LinkedList<>(adjacencyLists.get(vertex));
    }

    public int size() {
        return numberOfVertices;
    }

    @Override
    public int compareTo(Graph<T> o) {
        throw new UnsupportedOperationException("Graph does not implement compareTo()");
    }

    @Override
    public String toString() {
        return "Graph{" +
                "adjacencyLists=" + adjacencyLists +
                ", numberOfVertices=" + numberOfVertices +
                '}';
    }

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
}