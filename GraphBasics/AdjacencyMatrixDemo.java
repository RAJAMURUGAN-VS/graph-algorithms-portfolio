package GraphBasics;

import java.util.*;

class Graph {

    /**
     * Adjacency Matrix implementation of a Graph.
     *
     * Supports both directed and undirected graphs.
     * Stores graph connections in a V x V matrix where
     * matrix[u][v] = 1 indicates an edge from u to v.
     *
     * Example:
     * Edges: { {0,2}, {0,1}, {1,3} }
     *
     * Directed Graph:
     * 0 -> 1, 2
     * 1 -> 3
     *
     * Undirected Graph:
     * 0 -> 1, 2
     * 1 -> 0, 3
     * 2 -> 0
     * 3 -> 1
     *
     * Time Complexity:
     * - Edge Insertion: O(E)
     * - Print Graph: O(V²)
     *
     * Space Complexity:
     * - O(V²)
     */

    int adjMat[][];

    Graph(int nodes) {
        adjMat=new int[nodes][nodes];
    }

    public void addEdgesInMat(int edges[][],boolean isDir) {
        
        for(int e[] : edges) {
            int u=e[0];
            int v=e[1];
            adjMat[u][v]=1;
            if(!isDir)
                adjMat[v][u]=1;
        }
    }

    public void printMat(boolean isDir) {

        int i=0;

        System.out.println((isDir?"Directed":"Undirected")+" graph");

        for(int row[] : adjMat) {
            System.out.print("row "+i + "-> ");
            for(int e : row)
                System.out.print(e+",");
            System.out.println();
            i++;
        }

        System.out.println();
    }
}

class AdjacencyMatrixDemo {

    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        
        int edges[][] = {{0,2},{0,1},{1,3}};
        int nodes=4;

        //Directed Graph
        Graph dg=new Graph(nodes);
        dg.addEdgesInMat(edges,true);
        dg.printMat(true);

        //Undirected Graph
        Graph udg=new Graph(nodes);
        udg.addEdgesInMat(edges,false);
        udg.printMat(false);

        sc.close();
    }
}