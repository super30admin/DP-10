class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0; 
        
        int n = nums.length;
         int dp[][] = new int[n][n];


        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int x = i; x <= j; x++) {
                    int leftValue = 1;
                    int rightValue = 1;
                    if (i != 0) {
                        leftValue = nums[i-1];
                    }

                    if (j != n -1) {
                        rightValue = nums[j+1];
                    }

                    int before = 0;
                    int after = 0;
                    if (i != x) {
                        before = dp[i][x-1];
                    }
                    if (j != x) {
                        after = dp[x+1][j];
                    }
                    dp[i][j] = Math.max(leftValue * nums[x] * rightValue + before + after, dp[i][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}