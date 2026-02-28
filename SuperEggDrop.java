// Time Complexity : O(nk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// O(nk)
// dp[i][j] -> number of floors we can explore with i attempts and j eggs
// with n attempts we check for eggs 1 to k  and consider the max floors we can explore
//  at each attempt we have 2 options
//  1. break -> we have i-1 attempts and j-1 eggs
//  2. not break -> we have i-1 attempts and j eggs
//  we consider both options and take the maximum floors we can explore
// when the max floors we explore reach n , we return the number of attempts required

class Solution {

    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n + 1][k + 1];
        int attempts = 0;
        while (dp[attempts][k] < n) {
            attempts++;
            for (int j = 1; j <= k; j++)
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j];
        }

        return attempts;
    }

    // O(n^2*k)
    // dp[i][j] -> min attemps to find with i eggs and j floors
    // At each [i][j] we check for each floors 1->j and take min out of them
    // at each floor we have two options
    // 1. break -> we have i-1 eggs and below floors of f-1
    // 2. not break -> we still have i eggs and top floors of j-f
    // we take the worst case of both options and take the minimum attempts of all
    // the floors as start point

    public int superEggDrop2(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for (int j = 1; j <= n; j++)
            dp[1][j] = j;

        // each number of eggs
        for (int i = 2; i <= k; i++) {
            // each number of floors
            for (int j = 1; j <= n; j++) {
                int currMin = Integer.MAX_VALUE;
                // each floor break,no break check
                for (int f = 1; f <= j; f++) {
                    currMin = Math.min(currMin, 1 + Math.max(dp[i - 1][f - 1], dp[i][j - f]));
                }
                dp[i][j] = currMin;
            }
        }

        return dp[k][n];
    }

}