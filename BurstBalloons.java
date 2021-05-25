class BurstBalloons {
    
    // Time Complexity: O(n^3)
    // Space Complexity: O(n*n)
    
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for(int len = 1; len <= n; len++){
            for(int i = 0; i <= n - len; i++){
                int j = i + len - 1;
                for(int burst = i; burst <= j; burst++){
                    int before = 0;
                    int after = 0;
                    int mulLeft = 1;
                    int mulRight = 1;
                    
                    if(i != 0)
                        mulLeft = nums[i - 1];
                    
                    if(j != n-1)
                        mulRight = nums[j + 1];
                    
                    if(burst != i)
                        before = dp[i][burst - 1];
                    
                    if(burst != j)
                        after = dp[burst + 1][j];
                    
                    dp[i][j] = Math.max(dp[i][j], before + mulLeft * nums[burst] * mulRight + after);
                }
            }
        }
        
        return dp[0][n-1];
    }
}