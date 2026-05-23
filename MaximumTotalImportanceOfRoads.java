import java.util.*;

class MaximumTotalImportanceOfRoads {

    /**
     * LeetCode 2285 - Maximum Total Importance of Roads
     *
     * Problem:
     * Assign unique importance values from 1 to n to the cities
     * such that the total importance of all roads is maximized.
     *
     * The importance of a road is the sum of the importance values
     * assigned to the two cities connected by that road.
     *
     * Approach:
     * - Count the degree of each city.
     * - Cities with higher degrees contribute to more roads.
     * - Sort the degrees in ascending order.
     * - Assign smaller importance values to lower degrees and
     *   larger importance values to higher degrees.
     * - Compute the maximum total importance.
     *
     * Example:
     * n = 5
     * roads = [[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]
     *
     * Degrees:
     * 0 -> 2
     * 1 -> 3
     * 2 -> 4
     * 3 -> 2
     * 4 -> 1
     *
     * Sorted Degrees:
     * [1,2,2,3,4]
     *
     * Assigned Importance:
     * [1,2,3,4,5]
     *
     * Maximum Total Importance:
     * (1×1) + (2×2) + (2×3) + (3×4) + (4×5) = 43
     *
     * Time Complexity: O(R + N log N)
     * Space Complexity: O(N)
     */

    public long maximumImportance(int n, int[][] roads) {
        
        long degree[]=new long[n];

        for(int road[] : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        Arrays.sort(degree);

        long res=0;

        for(int i=1;i<=n;i++)
            res+=(degree[i-1]*i);

        return res;
    }

    public static void main(String[] args) {

        int n = 5;

        int[][] roads = {
            {0,1},
            {1,2},
            {2,3},
            {0,2},
            {1,3},
            {2,4}
        };

        MaximumTotalImportanceOfRoads obj = new MaximumTotalImportanceOfRoads();

        System.out.println(
            "Maximum Total Importance: "
            + obj.maximumImportance(n, roads)
        );
    }
}