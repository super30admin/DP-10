// Problem 312. Burst Balloons
// Time Complexity : O(n*n*n)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int l = 1; l <= n; l++){
            for(int i=0; i<=n-l; i++){
                int j = i+l-1;
                int max = Integer.MIN_VALUE;
                for (int k=i; k<=j; k++) {
                    int leftBursted = 0;
                    int rightBursted = 0;
                    if(i != k){
                        leftBursted = dp[i][k-1];
                    }
                    if(j != k){
                        rightBursted = dp[k+1][j];
                    }
                    int leftN = 1;
                    if(i != 0){
                        leftN = nums[i-1];
                    }
                    int rightN = 1;
                    if(j != n-1){
                        rightN = nums[j+1];
                    }
                    int curr = leftBursted + leftN * nums[k] * rightN + rightBursted;
                    max = Math.max(max, curr);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n-1];
    }
}
