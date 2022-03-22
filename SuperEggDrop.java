// Time Complexity : O(n*k) ; n - no. of floors, k - no. of eggs
// Space Complexity : O(n*k)
// Did this code successfully run on Leetcode : Yes

public class SuperEggDrop {

    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n+1][k+1];

        int attempts = 0;

        while(dp[attempts][k] < n){
            attempts++;
            for(int j = 1;j < dp[0].length; j++){
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j];
            }
        }
        return attempts;
    }
}
