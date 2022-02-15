// Time Complexity = O(n^3)
// Space Complexity = O(n^2)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// This is solved using Probability with DP
class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        if(nums == null || nums.length == 0) return 0;

        int[][] dp = new int[n][n];

        // we evaluate subsets starting from size 1 to the length of the nums array
        for (int len = 1; len <= n; len++) {

            // starting index of ballons I can burst
            for (int i=0; i<=n-len; i++) {
                // ending index of ballons I can burst
                int j = i+len-1;

                for (int k=i; k <= j; k++) {
                    int before=0, after=0;

                    if(k != i) {
                        before = dp[i][k-1];
                    }

                    if (k != j) {
                        after = dp[k+1][j];
                    }

                    int left=1, right=1;

                    if(i != 0) {
                        left = nums[i-1];
                    }

                    if (j != n-1) {
                        right = nums[j+1];
                    }
                    dp[i][j] = Math.max(dp[i][j], before + (left * nums[k] * right) + after);
                }
            }
        }

        return dp[0][n-1];
    }
}