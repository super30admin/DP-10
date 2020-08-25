// Time Complexity : O(n^3) --> where n is the length of input array
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode (312): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int maxCoins(int[] nums) {
        // edge case
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int dp[][] = new int[n][n];
        for (int len = 1; len <= n; len++) { // len is decision making sub-array
            // start index of sub array
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; //end index of my each sub array
                for (int k = i; k <= j; k++) {
                    // if kth is the baloon which is burst in the end
                    int left = 1; int right = 1;
                    if (j != n-1) right = nums[j+1];
                    if (i != 0) left = nums[i-1];
                    
                    int before = 0; int after = 0;
                    if (k != i) before = dp[i][k-1];
                    if (k != j) after = dp[k+1][j];
                    
                    dp[i][j] = Math.max(dp[i][j], before + left * nums[k] * right + after);
                }
            }
        }
        return dp[0][n-1];
    }
}