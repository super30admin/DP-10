 // Time - O(N^3), Space - O(N^2)

class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for(int len=1;len<=n;len++) {
            for(int i=0;i<=n-len;i++) {
                int j = i + len - 1;                
                for(int k=i;k<=j;k++) {
                    int before = 0;
                    int after = 0;
                    if(k!=0) {
                        before = dp[i][k-1];
                    }
                    if(k != n -1) {
                        after = dp[k + 1][j];
                    }
                    int leftVal = 1;
                    int rightVal = 1;
                    if(i != 0) {
                        leftVal = nums[i-1];
                    }
                    if(j!=n-1) {
                        rightVal = nums[j+1];
                    }
                    dp[i][j] = Math.max(dp[i][j], before + leftVal * nums[k] * rightVal + after);
                }
                
            }
        }
        
        return dp[0][n-1];
    }
}
