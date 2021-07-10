// Time Complexity :O(n^2 * k) for Approach 1 and O(nk)  for approach 2
// Space Complexity :O(n*k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Code with binary search
class Solution {
    public int superEggDrop(int K, int N) {
        
        //Approach 1
        // int [][] dp = new int[N+1][N+1];
        // for(int i = 0; i <=N;i++)
        // {
        //     dp[1][i]= i;
        // }
        // for(int i = 2;i <=K;i++)
        // {
        //     for(int j = 1; j <=N;j++)
        //     {
        //         dp[i][j] = Integer.MAX_VALUE;
        //         for(int k = 1;k<=j;k++)
        //         {
        //             dp[i][j] = Math.min(dp[i][j], 1+ Math.max(dp[i-1][k-1],dp[i][j-k]));
        //         }
        //     }
        // }
        //return dp[K][N];
        
        // Approach 2
        int [][] dp = new int[N+1][K+1];
        
        int attempts = 0;
        while(dp[attempts][K]<N)
        {
            attempts++;
            for(int j = 1;j<=K;j++)
            {
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];
            }
        }
        return attempts;
        
    }
}