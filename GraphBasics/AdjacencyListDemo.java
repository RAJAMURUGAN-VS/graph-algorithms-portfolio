package GraphBasics;

import java.util.*;

class AdjacencyListGraph {

    /**
     * Adjacency List implementation of a Graph.
     *
     * Supports both directed and undirected graphs.
     * Stores graph connections using a list of lists,
     * where each vertex maintains a list of its adjacent vertices.
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
     * Time Complexity:
     * - Edge Insertion: O(E)
     * - Graph Traversal/Printing: O(V + E)
     *
     * Space Complexity:
     * - O(V + E)
     */

    List<List<Integer>> adjList;

    AdjacencyListGraph(int nodes) {
        adjList=new ArrayList<>();
        for(int i=0;i<nodes;i++)
            adjList.add(new ArrayList<>());
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

    public void printList(boolean isDir) {

        int i=0;

        System.out.println((isDir?"Directed":"Undirected")+" graph");

        for(List<Integer> row : adjList) {
            System.out.print("row "+i + " -> [");
            for(int e : row)
                System.out.print(e+",");
            System.out.println("]");
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
    }
}