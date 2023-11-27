
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

    @Test
    public void testBreadthFirstTraversalSingleNode() {
        Graph<String> graph = new Graph<>(1);
        Vertex<String> node = graph.addVertex("Node");
        List<Vertex<String>> traversalResult = graph.breadthFirst(node);

        assertEquals(1, traversalResult.size());
        assertEquals(node, traversalResult.get(0));
    }

    @Test
    public void testBreadthFirstTraversalDisconnectedNodes() {
        Graph<Integer> graph = new Graph<>(5);
        Vertex<Integer> node1 = graph.addVertex(1);
        Vertex<Integer> node2 = graph.addVertex(2);
        Vertex<Integer> node3 = graph.addVertex(3);

        List<Vertex<Integer>> traversalResult = graph.breadthFirst(node1);

        assertEquals(1, traversalResult.size());
        assertEquals(node1, traversalResult.get(0));
    }

    @Test
    public void testBreadthFirstTraversalComplexGraph() {
        Graph<Character> graph = new Graph<>(6);
        Vertex<Character> nodeA = graph.addVertex('A');
        Vertex<Character> nodeB = graph.addVertex('B');
        Vertex<Character> nodeC = graph.addVertex('C');
        Vertex<Character> nodeD = graph.addVertex('D');
        Vertex<Character> nodeE = graph.addVertex('E');
        Vertex<Character> nodeF = graph.addVertex('F');

        graph.addEdge(nodeA, nodeB);
        graph.addEdge(nodeA, nodeC);
        graph.addEdge(nodeB, nodeD);
        graph.addEdge(nodeB, nodeE);
        graph.addEdge(nodeC, nodeF);

        List<Vertex<Character>> traversalResult = graph.breadthFirst(nodeA);

        assertEquals(6, traversalResult.size());
        assertEquals(nodeA, traversalResult.get(0));
        assertEquals(nodeB, traversalResult.get(1));
        assertEquals(nodeC, traversalResult.get(2));
        assertEquals(nodeD, traversalResult.get(3));
        assertEquals(nodeE, traversalResult.get(4));
        assertEquals(nodeF, traversalResult.get(5));
    }

    @Test
    void businessTripTest() {
        Graph<String> cityGraph = new Graph<>(10);

        Vertex<String> cityA = cityGraph.addVertex("CityA");
        Vertex<String> cityB = cityGraph.addVertex("CityB");
        Vertex<String> cityC = cityGraph.addVertex("CityC");

        cityGraph.addEdge(cityA, cityB, 100);
        cityGraph.addEdge(cityB, cityC, 150);

        String[] tripCities1 = {"CityA", "CityB", "CityC"};
        Integer tripCost1 = Graph.businessTrip(cityGraph, tripCities1);
        assertEquals(250, tripCost1);

        String[] tripCities2 = {"CityA", "CityC"};
        Integer tripCost2 = Graph.businessTrip(cityGraph, tripCities2);
        assertNull(tripCost2);

        String[] tripCities3 = {"CityA"};
        Integer tripCost3 = Graph.businessTrip(cityGraph, tripCities3);
        assertNull(tripCost3);
    }



    @Test
    public void testDepthFirstTraversal() {
        Graph<String> graph = new Graph<>(10);

        Vertex<String> vertexA = graph.addVertex("A");
        Vertex<String> vertexB = graph.addVertex("B");
        Vertex<String> vertexC = graph.addVertex("C");
        Vertex<String> vertexD = graph.addVertex("D");
        Vertex<String> vertexE = graph.addVertex("E");

        graph.addEdge(vertexA, vertexB);
        graph.addEdge(vertexA, vertexC);
        graph.addEdge(vertexB, vertexD);
        graph.addEdge(vertexC, vertexE);

        List<Vertex<String>> depthFirstNodes = graph.depthFirst(vertexA);


        assertEquals(5, depthFirstNodes.size());
        assertEquals(vertexA, depthFirstNodes.get(0));
        assertEquals(vertexB, depthFirstNodes.get(1));
        assertEquals(vertexD, depthFirstNodes.get(2));
        assertEquals(vertexC, depthFirstNodes.get(3));
        assertEquals(vertexE, depthFirstNodes.get(4));
    }
}
