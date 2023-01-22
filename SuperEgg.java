public class SuperEgg {
//TC O(n*k) SC O(n*k)
    public int superEggDrop(int k, int n) {
        if(k==0 || n == 0) return 0;
        int[][] dp = new int[n+1][k+1];
        int attempts =0;
        while(dp[attempts][k]<n){
            attempts++;
            for(int j = 1;j<k+1;j++){
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];

            }

        }

        return attempts;

    }

    //TC O(n^2*k) SC O(n*k)
    /* public int superEggDrop(int k, int n) {
        if(k==0 || n == 0) return 0;
        int[][] dp = new int[k+1][n+1];

        for(int i = 1;i<n+1;i++){
            dp[1][i] = i;
        }
        for(int i =2;i<k+1;i++){
            for(int j = 1;j<n+1;j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int f = 1;f<=j;f++){
                    dp[i][j]= Math.min(dp[i][j], 1+ Math.max(dp[i-1][f-1],dp[i][j-f]));
                }
            }
        }
        return dp[k][n];

    }*/
}
