//O(nk) time
//O(nk) space
class Solution {
    public int superEggDrop(int k, int n) {
        int dp[][] = new int[n+1][k+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                dp[i][j] = 1 + dp[i-1][j] + dp[i-1][j-1];
                if(dp[i][j] >= n )
                    return i;
            }
        }
        return n;
    }
}