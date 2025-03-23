class Solution {
    public int superEggDrop(int k, int n) {
        
            int[][] dp = new int [n+1][k+1];

            for (int i = 1;i <= k;i++){
                dp [1][i] = 1;
                        if (dp[1][i] >=n)
                        return i;
                
            }

                for (int i =2;i <=n;i++){
                    for (int j = 1;j <=k;j++){
                        dp [i][j] = 1 +dp[i-1][j-1] + dp[i-1][j];
                        if (dp[i][j] >=n)
                        return i;
                    }
                }
                return -1;
        //the solution below gives a TLE

    //     int[][] dp = new int [k+1][n+1];

    //     //fill the 1 egg row
    //     for (int i =0 ; i <= n; i++){
    //         dp [1][i] =i;
    //     }
    //      for (int i =2 ; i <= k; i++){
    //      for (int j =1 ; j <= n; j++){
    //         dp[i][j] = Integer.MAX_VALUE;
    //      for (int f =1 ; f <= j; f++){
    //         dp [i][j] = Math.min(dp[i][j],1 + Math.max (dp[i][j-f], dp[i-1][f-1]));

    //         }
    //     }

    // }
    //         return dp [k][n];
}
}
