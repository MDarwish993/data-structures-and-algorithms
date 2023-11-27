# Challenge 37
#### Implement  business trip function.
## Picture of whiteboard
<img src="C:\Users\C-ROAD\IdeaProjects\data-structures-and-algorithms\codeChallenges05\app\src\assets\cc37.jpg "/>

### - Initial business trip Method:
- Arguments:   graph, array of city names.
- Return: the cost of the trip (if it’s possible) or null (if not).
## Solution
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