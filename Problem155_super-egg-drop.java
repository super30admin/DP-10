// Time Complexity: O(nk)
// Space Complexity: O(nk) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int superEggDrop(int k, int n) {
        // attempts on row
        int[][] dp = new int[n + 1][k + 1];
        int attempts = 0;
        while(dp[attempts][k] < n) { // continue filling the matrix
            attempts++;
            for(int j = 1; j <= k; j++) {
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j];
            }
        }
        return attempts;
    }
}