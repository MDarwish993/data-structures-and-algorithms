
package codechallenges05;

import graphDataStructure.Graph;
import graphDataStructure.Vertex;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class GraphDataStructureTest {
    @Test
    void addVertexAndGetVertices() {
        Graph<Integer> graph = new Graph<>(5);
        Vertex<Integer> vertex1 = graph.addVertex(1);
        Vertex<Integer> vertex2 = graph.addVertex(2);
        Vertex<Integer> vertex3 = graph.addVertex(3);

        List<Vertex<Integer>> vertices = graph.getVertices();

        assertEquals(3, graph.size());
        assertTrue(vertices.contains(vertex1));
        assertTrue(vertices.contains(vertex2));
        assertTrue(vertices.contains(vertex3));
    }


    @Test
    void addEdgeInvalidVertices() {
        Graph<Character> graph = new Graph<>(5);
        Vertex<Character> vertexA = graph.addVertex('A');
        Vertex<Character> vertexB = new Vertex<>('B'); // Not added to the graph

        assertThrows(IllegalArgumentException.class, () -> graph.addEdge(vertexA, vertexB, 3));
    }

    @Test
    void size() {
        Graph<Double> graph = new Graph<>(5);
        graph.addVertex(1.0);
        graph.addVertex(2.0);
        graph.addVertex(3.0);

        assertEquals(3, graph.size());
    }
    @Test
    void getVertices() {
        Graph<Integer> graph = new Graph<>(5);
        Vertex<Integer> vertex1 = graph.addVertex(1);
        Vertex<Integer> vertex2 = graph.addVertex(2);
        Vertex<Integer> vertex3 = graph.addVertex(3);

        List<Vertex<Integer>> vertices = graph.getVertices();

        assertEquals(3, vertices.size());
        assertTrue(vertices.contains(vertex1));
        assertTrue(vertices.contains(vertex2));
        assertTrue(vertices.contains(vertex3));
    }
}
