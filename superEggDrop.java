// Time Complexity : O(N)
// Space Complexity : O(N*N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int superEggDrop(int k, int n) {
        if(k == 1 || n <= 1)
            return n;
        int[][] dp = new int[n+1][k+1];
        int attempts = 0;

        while(dp[attempts][k] < n){
            attempts += 1;
            for(int j = 1; j <= k; j++){
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j];
            }
        }
        return attempts;
    }
}
