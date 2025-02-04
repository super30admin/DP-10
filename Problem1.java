class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n+1][k+1];
        for(int i = 0;i<=k;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j=0;j<=k;j++){
                if(j==0){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = 1 + dp[i-1][j-1] + dp[i-1][j];
                }

                if(dp[i][j]>=n){
                    return i;
                }
            }
        }

        return 0;

        
    }
}