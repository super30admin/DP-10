// Time Complexity : O(N^3)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class burstBalloons {
    public int maxCoins(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int[][] dp = new int[len][len];


        for(int i = nums.length - 1; i >= 0; i--) {	
            for(int j = i; j <= nums.length - 1; j++) { 
                for(int k = i; k <= j; k++) {
                    int val = 0;
                    val += (k == i) ? 0 : dp[i][k-1];
                    val += (k == j) ? 0 : dp[k+1][j];
                    val += ((i==0) ? 1 : nums[i-1]) * nums[k] * ((j==len-1) ? 1 : nums[j+1]);
                    dp[i][j] = Math.max(dp[i][j], val);
                }
            }
        }
        return dp[0][len-1];
    }
}
