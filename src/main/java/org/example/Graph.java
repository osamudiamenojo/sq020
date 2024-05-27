package org.example;

import java.util.*;

    public class Graph {
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

