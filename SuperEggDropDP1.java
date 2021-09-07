// Time Complexity : O(n ^ 3)
// Space Complexity : O(n * k)

class Solution {
    public int superEggDrop(int k, int n) {
        int dp[][] = new int[k + 1][n + 1];
        
        for(int j = 1; j < dp[0].length; j++){
            dp[1][j] = j;
        }
        
        for(int i = 2; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int f = 1; f <= j; f++){
                    dp[i][j] = Math.min(dp[i][j] , 1 + Math.max(dp[i - 1][f - 1], dp[i][j - f]));
                }
            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1];
    }
}