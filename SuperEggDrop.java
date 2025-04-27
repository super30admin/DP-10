/**
 * Time Complexity: O(n*k)
 * Space Complexity: O(n*k) in 2D DP approach and O(k) in 1D DP approach
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * DP bottom-up approach by using the attempts and eggs as the states
 */

public class SuperEggDrop {
    // ----------- Approach 1 - 2D DP array, SC: O(n*k)-----------------
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i < n + 1; i ++) {
            for (int j = 1; j < k + 1; j++) {
                dp[i][j] = 1 + dp[i-1][j-1] + dp[i-1][j];
                if (dp[i][j] >= n) {
                    return i;
                }
            }
        }

        return -1;
    }

    // ----------- Approach 2 - 1D DP array, SC: O(k) ---------------
    public int superEggDrop2(int k, int n) {
        int[] dp = new int[k + 1];

        for (int moves = 1; moves < n+1; moves++) {
            int[] prev = dp.clone();
            for (int j = 1; j < k + 1; j++) {
                dp[j] = 1 + prev[j-1] + prev[j];
                if (dp[j] >= n) {
                    return moves;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Your code here
    }
}