// Time Complexity : O(n*n)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class BurstBalloon {
    class Solution {
        public int maxCoins(int[] nums) {
            int n = nums.length;
            if(n == 0 || nums == null)
                return 0;

        /*DP-permutation
        burstable array from 1 - n
        first consider nursting only one balloon, then 2 ballons burst with
        2 diff bursting, considering each balloon bursting at the end, then in burstable array 3, 4 .. n
        Take max of from all the burstable balloons
        max = Math.max(max, before+(left*curr*right)+after) */
            int dp[][] = new int[n][n];

            for(int len = 1; len <= n; len++){
                for(int i = 0; i <= n-len; i++){
                    int j = i + len - 1;
                    int max = 0;
                    for(int k = i; k <= j; k++){
                        int before = 0;
                        if(i != k){
                            before = dp[i][k-1];
                        }
                        int after = 0;
                        if(j != k){
                            after = dp[k+1][j];
                        }
                        int left = 1;
                        if(i != 0){
                            left = nums[i-1];
                        }
                        int right = 1;
                        if(j != n-1){
                            right = nums[j+1];
                        }

                        max = Math.max(max, before + (left * nums[k] * right) + after);
                    }
                    dp[i][j] = max;
                }
            }
            return dp[0][n-1];
        }
    }
}
