package org.example;

import java.util.List;

public class Testing {
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
