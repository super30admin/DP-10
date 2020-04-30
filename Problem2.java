// Time Complexity : O(n^3)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: use the apprach of bursting balloon and checking its leftGain and rightGain. Calculate the self value and check for its left and right

class Solution {
    public int maxCoins(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[][] gain = new int[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                for (int k = i; k <= j; k++) {
                    int leftGain = 0;
                    int rightGain = 0;

                    if (k != i)
                        leftGain = gain[i][k - 1];
                    if (k != j)
                        rightGain = gain[k + 1][j];

                    int leftBalloon = 1;
                    int rightBalloon = 1;

                    if (i != 0)
                        leftBalloon = nums[i - 1];
                    if (j != n - 1)
                        rightBalloon = nums[j + 1];

                    gain[i][j] = Math.max(gain[i][j], leftGain + leftBalloon * nums[k] * rightBalloon + rightGain);
                }
            }
        }

        return gain[0][n - 1];

    }
}