//Time n^2 * k 
// Space O(nk)
class Solution {
    public int superEggDrop(int k, int n) {
 
    int[][] dp = new int[k+1][n+1]; // dp to keep track of subproblem answers
    for(int i=0;i<=n;i++)
    {dp[0][i]=0;
     dp[1][i]=i;
    }
    for( int i =0;i<=k;i++)
        dp[i][0]=0;
        
      
     // for(int [] t:dp)
     //     System.out.println(Arrays.toString(t));
    for(int i =2;i<dp.length;i++)
    {
        for( int j =1;j<=n;j++)
        {   // j represents the floor. we need to take the minimum value after considering dropping from all floors from 1 to j
            int min = Integer.MAX_VALUE;
            for( int t=1;t<=j;t++)
            {   min = Math.min(min, 1+ Math.max(dp[i-1][t-1], dp[i][j-t]));
                
            }
            dp[i][j] =min;
            
        }
    }
        
        return dp[k][n];
        
    }
}