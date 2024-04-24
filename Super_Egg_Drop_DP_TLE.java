
//DP solution
//For dp solution we get time limit exceeded
class Solution {
    public int superEggDrop(int k, int n) {
        int [][]dp = new int[k+1][n+1];
        for(int i = 1; i<= n; i++) {
           dp[1][i] = i; 
        }

        for(int i = 2; i<=k;i++) {
            for(int j = 1; j<= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for(int floor = 1; floor <= j;floor++) {
                                                            // Break scenario     // No break scenario
                    dp[i][j] = Math.min(dp[i][j] , (1+ Math.max(dp[i-1][floor-1], dp[i][j-floor])));
                }
            }
        }
        return dp[k][n];
    }
}