package GraphBasics;

import java.util.*;

class AdjacencyListGraph {

    /**
     * Adjacency List implementation of a Graph.
     *
     * Supports:
     * - Directed Graphs
     * - Undirected Graphs
     * - Weighted Graphs
     * - Unweighted Graphs
     *
     * Unweighted Representation:
     * Each vertex maintains a list of its adjacent vertices.
     *
     * Example:
     * Edges: { {0,2}, {0,1}, {1,3} }
     *
     * Directed Graph:
     * 0 -> [2, 1]
     * 1 -> [3]
     * 2 -> []
     * 3 -> []
     *
     * Undirected Graph:
     * 0 -> [2, 1]
     * 1 -> [0, 3]
     * 2 -> [0]
     * 3 -> [1]
     *
     * Weighted Representation:
     * Each edge is stored as a pair (neighbor, weight).
     *
     * Example:
     * Edges: { {0,2,10}, {0,1,20}, {1,3,30} }
     *
     * Directed Weighted Graph:
     * 0 -> [(2,10), (1,20)]
     * 1 -> [(3,30)]
     * 2 -> []
     * 3 -> []
     *
     * Time Complexity:
     * - Edge Insertion: O(E)
     * - Graph Traversal/Printing: O(V + E)
     *
     * Space Complexity:
     * - O(V + E)
     */

    class Pair {

        int node;
        int weight;
        Pair(int node,int weight) {
            this.node=node;
            this.weight=weight;
        }

        @Override
        public String toString() {
            return "("+node+","+weight+")";
        }
    }

    List<List<Integer>> adjList;
    List<List<Pair>> adjListWithWeight;

    AdjacencyListGraph(int nodes) {
        adjList=new ArrayList<>();
        adjListWithWeight=new ArrayList<>();
        for(int i=0;i<nodes;i++) {
            adjList.add(new ArrayList<>());
            adjListWithWeight.add(new ArrayList<>());
        }
    }

    public void addEdgesInList(int edges[][],boolean isDir) {
        
        for(int e[] : edges) {
            int u=e[0];
            int v=e[1];
            adjList.get(u).add(v);
            if(!isDir)
                adjList.get(v).add(u);
        }
    }

    public void addEdgesWithWeightInList(int edges[][],boolean isDir) {
    
        for(int e[] : edges) {
            int u=e[0];
            int v=e[1];
            int w=e[2];
            Pair pair=new Pair(v,w);
            adjListWithWeight.get(u).add(pair);

            if(!isDir) {
                pair=new Pair(u,w);
                adjListWithWeight.get(v).add(pair);
            }
        }
    }

    public void printList(boolean isDir) {

        int i=0;

        System.out.println((isDir?"Directed":"Undirected")+" graph");

        for(List<Integer> row : adjList) {
            System.out.println("row "+i + " -> "+row);
            i++;
        }

        System.out.println();
    }

    public void printWeightedList(boolean isDir) {
        
        int i=0;

        System.out.println((isDir?"Directed":"Undirected")+" graph");

        for(List<Pair> row : adjListWithWeight) {
            System.out.println("row "+i + " -> "+row);
            i++;
        }

        System.out.println();
    }
}

class AdjacencyListDemo {

    public static void main(String args[]) {
        
        int nodes=4;

        //Without Weight
        System.out.println("1.Edges without weight\n");

        int edges[][] = {{0,2},{0,1},{1,3}};

        //Directed Graph
        AdjacencyListGraph dg=new AdjacencyListGraph(nodes);
        dg.addEdgesInList(edges,true);
        dg.printList(true);

        //Undirected Graph
        AdjacencyListGraph udg=new AdjacencyListGraph(nodes);
        udg.addEdgesInList(edges,false);
        udg.printList(false);

        //Without Weight
        System.out.println("2.Edges with weight\n");

        int edgesWithWeight[][] = {{0,2,10},{0,1,20},{1,3,30}};

        //Directed Graph
        AdjacencyListGraph dgw=new AdjacencyListGraph(nodes);
        dgw.addEdgesWithWeightInList(edgesWithWeight,true);
        dgw.printWeightedList(true);

        //Undirected Graph
        AdjacencyListGraph udgw=new AdjacencyListGraph(nodes);
        udgw.addEdgesWithWeightInList(edgesWithWeight,false);
        udgw.printWeightedList(false);
    }
}