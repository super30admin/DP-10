class Solution {
    //tc-o(NK)
    //sc-o(nK)
    public int superEggDrop(int k, int n) {
    //atempts and egg matrix filled with no of floors
    int[][]dp = new int[n+1][k+1];
    int attempts = 0;
    while(dp[attempts][k] < n)
    {
        attempts++;
        for(int j=1;j<=k;j++)
        {
            dp[attempts][j] = 1+ dp[attempts-1][j-1]+ dp[attempts-1][j];
        }
 
    }
    return attempts;
    }
}