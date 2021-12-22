class Solution {
    public int superEggDrop(int k, int n) {
        int [][] dp = new int[n+1][k+1];
        int attempt = 0;
        
        while(dp[attempt][k] < n){
            attempt++;
            for(int j = 1; j < dp[0].length; j++){
                dp[attempt][j] = 1+dp[attempt - 1][j - 1] + dp[attempt - 1][j];
            }
        }
        return attempt;
    }
}

//TC: O(n * K)
//SC: O(n*k)
