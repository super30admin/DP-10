/* Time Complexity : O(n*k)
 *  n - no. of floors */
/* Space Complexity : O(n*k)
 * k - no. of eggs */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n+1][k+1];
        int attempts = 0;
        //Till value of floors in the dp array exceed given floor value(n)
        while(dp[attempts][k] < n){
            attempts++;
            for(int j = 1; j <= k; j++){
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];
            }
        }
        return attempts;
    }
}
