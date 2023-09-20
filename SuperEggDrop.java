// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : Yes

public class SuperEggDrop {
    // n^2 k solution
    // Time Complexity : O(n^2 k) -> n is the number of floors and k is the number of eggs
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];

        for(int j=1; j<=n; j++){
            dp[1][j] = j;
        }

        for(int i=2; i<=k; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int f=1; f<=j; f++){

                    dp[i][j] = Math.min(dp[i][j],(1+Math.max(dp[i-1][f-1],dp[i][j-f])));
                }
            }
        }
        return dp[k][n];
    }
    //nk solution
    // Time Complexity : O(n k) -> n is the number of floors and k is the number of eggs
    public int superEggDrop1(int k, int n) {
        int[][] dp = new int[n+1][k+1];

        int attempts = 0;

        while(dp[attempts][k] < n){
            attempts++;
            for(int j=1; j<=k; j++)
            {
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];
            }
        }
        return attempts;
    }
}
