// Time Complexity : O(n^3)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We solve this recursively using dp with memoization and store the computed results and leverage them in the
next stages for repeated subproblems.For every subarray,We choose a balloon k to burst it last and compute the
maximum value and maintain a global maximum to compare and store in the memo matrix. We recursively call the
helper method to compute the state of the balloon before bursting and after by taking subarrays and the
value if we choose balloon itself.
 */
class Solution {
    int[][] memo;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        this.memo = new int[n][n];
        return helper(nums, 0, n - 1);
    }

    private int helper(int[] nums, int i , int j) {
        if(i > j)
            return 0;
        if(memo[i][j] != 0)
            return memo[i][j];
        int max = 0;
        for(int k = i ; k <= j ; k++) {
            int before = helper(nums, i, k - 1);
            int after = helper(nums, k + 1, j);
            int prev = 1 , next = 1;
            if(i > 0)
                prev = nums[i - 1];
            if(j < nums.length - 1)
                next = nums[j + 1];
            int balloonItself = prev * nums[k] * next;
            max = Math.max(max, before + after + balloonItself);
        }

        memo[i][j] = max;
        return max;
    }
}