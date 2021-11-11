// Time Complexity : O(n x k)
// Space Complexity : O(n x k)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n+1][k+1]; // rows is # attempts
        int attempts = 0;
        
        while(dp[attempts][k] < n){ // continue filling matrix
            attempts++;
            for(int j=1; j<=k; j++){
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];
            }
        }
        return attempts;
    }
}