// TC: O(n^3)
// SC: O(n^2)
class Solution {
    int[][] memo;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        memo = new int[n][n];

        return helper(nums, 0, n - 1);
    }

    private int helper(int[] nums, int i, int j) {
        if (i > j) {
            return 0;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {

            int before = helper(nums, i, k - 1);
            int after = helper(nums, k + 1, j);

            int prev = 1;
            if (i > 0) {
                prev = nums[i - 1];
            }

            int next = 1;
            if (j < nums.length -1) {
                next = nums[j + 1];
            }

            int ballon = prev * nums[k] * next;

            max = Math.max(max, before + ballon + after);

        }
        memo[i][j] = max;
        return max;
    }
}