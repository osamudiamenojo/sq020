package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    import java.util.*;

    class Graph {
        private Map<Integer, List<Integer>> adjacencyList;

        public Graph() {
            adjacencyList = new HashMap<>();
        }

        public void addVertex(int vertex) {
            adjacencyList.put(vertex, new ArrayList<>());
        }

        public void addEdge(int source, int destination) {
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source); // Uncomment for undirected graph
        }

        public List<Integer> getNeighbors(int vertex) {
            return adjacencyList.get(vertex);
        }

        public void printGraph() {
            for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
                System.out.print(entry.getKey() + " -> ");
                for (Integer neighbor : entry.getValue()) {
                    System.out.print(neighbor + " ");
                }
                System.out.println();
            }
        }
    }

    public class GraphExample {
        public static void main(String[] args) {
            Graph graph = new Graph();

            // Adding vertices
            graph.addVertex(1);
            graph.addVertex(2);
            graph.addVertex(3);

            // Adding edges
            graph.addEdge(1, 2);
            graph.addEdge(2, 3);

            // Print the graph
            graph.printGraph();

            // Get neighbors of a vertex
            List<Integer> neighbors = graph.getNeighbors(2);
            System.out.println("Neighbors of vertex 2: " + neighbors);
        }
    }

}