// Time Complexity : O(nk)
// Space Complexity : O(nk)

//here we're putting eggs (as a column) and number of attempts (as a row) to find how many maximum number of floor we can travel with particular case;

class EggDrop {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n+1][k+1];
        int attempt = 0;
        while(dp[attempt][k] < n){
            attempt++;
            for(int j=1; j<=k; j++){
                dp[attempt][j] = 1 + dp[attempt -1][j] + dp[attempt -1][j-1];
            }
        }
        return attempt;
    }
}