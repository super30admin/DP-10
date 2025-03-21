public class SuperEggDrop {

    //TC: O(k*(n^2))
    //SC: O(k*n)
    //approach: dp
    //failed with time limit exceeded for all some test cases
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];
        //filling second row
        for(int j=0;j<n+1;j++){
            dp[1][j] = j;
        }

        for(int i=2;i<=k;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int f=1; f<=j; f++){
                    dp[i][j] = Math.min(dp[i][j], 1+Math.max(dp[i-1][f-1], dp[i][j-f]));
                }
            }
        }
        return dp[k][n];
    }


    //TC: O(k*n)
    //SC: O(k*n)
    //approach: dp matrix of eggs and moves to calculate possible floors covered
    public int superEggDropOptimized(int k, int n) {
        int[][] dp = new int[n+1][k+1];
        int attempts = 0; //row=attempts, col=eggs
        while(dp[attempts][k]<n){
            attempts++;
            for(int j=1;j<=k;j++){
                dp[attempts][j] = 1+dp[attempts-1][j-1]+dp[attempts-1][j];
            }
        }
        return attempts;
    }
}
