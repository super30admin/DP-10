class Solution {
    //tc-o(n^2k)
    //sc-o(n^2)
    public int superEggDrop(int k, int n) {
    int[][]dp = new int[k+1][n+1];

    for(int j=1;j<=n;j++)
    {
     dp[1][j] = j;
    }
    for(int i=2;i<dp.length;i++)//rows->eggs
    {
        for(int j=1;j<dp[0].length;j++)
        {
            int min = Integer.MAX_VALUE;
            for(int f=1;f<=j;f++)
            {
             min =  Math.min(min,1+ Math.max(dp[i-1][f-1],dp[i][j-f]));
            }
            dp[i][j] = min;
        }
    }
    return dp[k][n];

    }
}