# Challenge Graphs
A graph is a data structure that consists of a set of nodes (vertices) and a set of edges connecting these nodes. It's a mathematical abstraction used to model pairwise relationships between different entities. Graphs are widely used in computer science and other fields to represent and solve problems involving relationships or connections.
## Problem Domain
Implement a Graph data structure and implement the methods for graph (add vertex,add edge,get vertices get neighbors,size)

### - Approach & Efficiency:
addVertex Time: Adding a vertex involves creating a new Vertex object and adding an entry to the adjacencyLists HashMap. Both of these operations are constant time, regardless of the number of existing vertices. Therefore, the time complexity for adding a vertex is O(1), and the space complexity is also O(1).

addedge Time: creating a new Edge object and adding it to the list of edges for a specific vertex. Both operations are constant time the time complexity for adding an edge is O(1), and the space complexity is also O(1).

getVertex Time: O(1), Space: O(n): n is the number of nodes getNeighbors Time: O(1), Space: O(m) (m is the number of neighbor nodes) operation is constant time because the list of edges is stored in a HashMap. The space complexity is O(m) because, in the worst case, a vertex can be connected to all other vertices in the graph.

size , Time: O(n): n is the number of nodes , Space: O(1)

addVertex(T value):

Adds a new vertex with the specified value to the graph.

addEdge(Vertex start, Vertex destination):

Adds an unweighted edge between the specified vertices.

addEdge(Vertex start, Vertex destination, int weight): Adds a weighted edge between the specified vertices.

getVertices():

Returns a list of all vertices in the graph.

getNeighbors(Vertex vertex):

Returns a list of edges representing neighbors of the specified vertex.

size():

Returns the number of vertices in the graph.

## Solution:

package graphDataStructure;

import java.util.HashMap;
import java.util.LinkedList;

import java.util.List;

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
}