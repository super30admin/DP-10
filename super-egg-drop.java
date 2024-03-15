class Solution {
    //TC: (nk)
    //SC: O(nk)
    public int superEggDrop(int k, int n) {
        int attempts = 0;
        int [][] dp = new int[n+1][k+1]; //dp arr of attempts and eggs
        while(dp[attempts][k] < n){
            //keep filling matrix
            attempts++;
            for(int j = 1; j <= k; j++){
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];
            }

        }
        return attempts;
    }
}
