//TC, SC - O(n*k)
class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n+1][k+1];
        
        int attemps = 0;
        
        while(dp[attemps][k] < n){ 
            attemps++;
            for(int j = 1; j <= k; j++){
                dp[attemps][j] = 1 + dp[attemps - 1][j-1] + dp[attemps - 1][j];
            }
        }
        return attemps;
    }
}
