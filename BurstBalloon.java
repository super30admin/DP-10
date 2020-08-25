/**
 * Algo: Bottom Up Approach - DP Solution
 * Each subarray of length starting from 1 to n is considered and in that each number is considered to be bursted at the end and thus calculated the max profit.
 * Using this calculated value, further subarray is calculated until the full array is considered and the profit is calculated.
 * Time: O(n ^3)
 * Space: O(n^2)
 *
 */
class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0 )return 0;

        int n = nums.length;
        int[][] dp = new int[nums.length][nums.length];

        for(int len = 1 ; len<= n; len++){
            for(int i=0;i<=n-len;i++){
                int j= i+len-1;
                for(int k=i;k<=j;k++){
                    int left = i-1 < 0 ? 1 : nums[i-1];
                    int right = j+1 >= n ? 1: nums[j+1];

                    int before = k-1 < 0 ? 0 : dp[i][k-1];
                    int after = k+1 >= n ? 0 : dp[k+1][j];

                    dp[i][j] = Math.max(dp[i][j],before+(left*nums[k]*right)+after);
                }
            }
        }

        return dp[0][n-1];
    }
}