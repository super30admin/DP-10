// Time Complexity: O(n^3)
// Space Complexity: O(n^2)
public class BurstBallons {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int n = nums.length;
        int [][] dp = new int[n][n]; // cost matrix
        // array lengths analyze
        for(int len = 1 ; len <= n ; len++) // sub problems 
        {
            // starting index
            for(int i = 0 ; i<= n-len  ; i++) 
            {
                // ending index
                int j = i + len -1;
                
                for(int k = i; k <= j ; k++) // for all permutation of sub problem size
                {
                    int before = 0, after = 0;
                    
                    if(k != i)
                    {
                        before = dp[i][k-1];
                    }
                    if (k != j)
                    {
                        after = dp[k+1][j];
                    }
                    int left = 1, right = 1;
                    if(i != 0)
                    {
                        left = nums[i-1];
                    }
                    if(j != n-1)
                    {
                        right = nums[j+1];
                    }
                    dp[i][j] = Math.max(dp[i][j], before + left * nums[k] * right + after);
                }
            }
        }
        
        return dp[0][n-1];
    }
}
