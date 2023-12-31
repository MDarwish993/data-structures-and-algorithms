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


    public static Integer businessTrip(Graph<String> graph, String[] cityNames) {
        if (cityNames == null || cityNames.length < 2) {
            return null; // Invalid input
        }

        int cost = 0;

        for (int i = 0; i < cityNames.length - 1; i++) {
            String startCityName = cityNames[i];
            String destinationCityName = cityNames[i + 1];

            Vertex<String> startVertex = findVertexByName(graph, startCityName);
            Vertex<String> destinationVertex = findVertexByName(graph, destinationCityName);

            if (startVertex == null || destinationVertex == null) {
                return null;
            }

            Edge<String> edge = findEdge(graph, startVertex, destinationVertex);

            if (edge == null) {
                return null;
            }

            cost += edge.weight;
        }

        return cost;
    }

    private static Vertex<String> findVertexByName(Graph<String> graph, String cityName) {
        for (Vertex<String> vertex : graph.adjacencyLists.keySet()) {
            if (vertex.value.equals(cityName)) {
                return vertex;
            }
        }
        return null;
    }

    private static Edge<String> findEdge(Graph<String> graph, Vertex<String> start, Vertex<String> destination) {
        List<Edge<String>> edges = graph.adjacencyLists.get(start);

        for (Edge<String> edge : edges) {
            if (edge.destination.equals(destination)) {
                return edge;
            }
        }
        return null;
    }




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


}