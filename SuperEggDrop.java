// Time Complexity : O(n*k)
// Space Complexity : 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// Approach : It is observed that the number of attemps remains same for a range of floors given same number of eggs and slowly increases
/// Flip the problem and let's to identify the max floors we can solve given number of attempts. We can find the number of floors by
/// adding 1 for current attempt plus number of floors given current egg breaks i.e, dp[attempts-1][eggs-1] plus number of floors given current
/// egg doesnt break i.e, dp[attempts-1][eggs]
class Solution {
    public int superEggDrop(int k, int n) {
        int dp[][] = new int[n+1][k+1];
        int attempts = 0;
        while(dp[attempts][k]<n){
            attempts++;
            for(int j=1;j<=k;j++){
                dp[attempts][j]=1+dp[attempts-1][j-1] + dp[attempts-1][j];
            }
        }
        return attempts;
    }
}