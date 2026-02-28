// Time Complexity : O(n^2*k)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// dp[i][j] represents max coins we can collect by bursting all ballons in [i,j]
//  we take each subarray of sizes 1 to n and take scenarios of bursting kth ballon last
//  [i,...,k,...,j] if we decide to burst kth ballon last -> from left we have [i,k-1] and right [k+1,j] and from k we get [i-1]*k*[j-1]
// Optimizing subarrays of sizes 1-> n we get max coins at full length subarray

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int[][] dp = new int[n][n];

        // sub arrays of size from 1->n
        for (int l = 1; l <= n; l++) {
            // each consecutive subarrays
            for (int i = 0; i + l <= n; i++) {
                // last index of subarray
                int j = i + l - 1;
                int max = -1;
                // find kth last ballon to burst
                for (int k = i; k <= j; k++) {
                    // nothing left/right of k condition
                    int leftBursted = k == i ? 0 : dp[i][k - 1];
                    int rightBursted = k == j ? 0 : dp[k + 1][j];

                    int leftNeighbour = i - 1 >= 0 ? nums[i - 1] : 1;
                    int rightNeighbour = j + 1 <= n - 1 ? nums[j + 1] : 1;

                    int curr = leftBursted +
                            leftNeighbour * nums[k] * rightNeighbour
                            + rightBursted;
                    max = Math.max(curr, max);
                }
                dp[i][j] = max;
            }
        }

        return dp[0][n - 1];
    }
}