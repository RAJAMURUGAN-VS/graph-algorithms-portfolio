import java.util.*;

class FindCenterOfStarGraph {

    /**
     * LeetCode 1791 - Find Center of Star Graph
     *
     * Problem:
     * Given the edges of a star graph, find the center node.
     *
     * Approach:
     * In a star graph, the center node appears in every edge.
     * Therefore, the common node between the first two edges
     * must be the center.
     *
     * Example:
     * Edges = [[1,2],[2,3],[4,2]]
     *
     * Common Node -> 2
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */

    public int findCenter(int[][] edges) {
        
        int pair1[]=edges[0];
        int pair2[]=edges[1];

        if(pair1[0]==pair2[0] || pair1[0]==pair2[1])
            return pair1[0];
        return pair1[1];
    }

    public static void main(String[] args) {

        int[][] edges = {
            {1, 2},
            {2, 3},
            {4, 2}
        };

        FindCenterOfStarGraph obj = new FindCenterOfStarGraph();

        System.out.println("Center Node: " + obj.findCenter(edges));
    }
}