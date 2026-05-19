// Time Complexity : O(n*k)
// Space Complexity : O(n*k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We use dp[i][j] array to find the max attempts needed with i attempts and j eggs. For each attempt, we take sum
of the above and below usecase to get the new range. As in, the sum of break and no break scenarios.We do this
until we cover n floors and return the attempt count.
 */
class Solution {
    public int superEggDrop(int k, int n) {
        int attempts = 0;
        int[][] dp = new int[n + 1][k + 1];

        while(dp[attempts][k] < n) {
            attempts++;
            for(int j = 1 ; j <= k ; j++) {
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j];
            }
        }
        return attempts;
    }
}