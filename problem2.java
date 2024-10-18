// Time Complexity : O(n³)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int maxCoins(int[] nums) {
        // Check if the input array is null or empty
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[][] dp = new int[n][n]; // DP table to store maximum coins
        
        // Loop over all possible lengths of the burstable subarrays
        for (int L = 1; L <= n; L++) {
            // Loop over all possible starting points of subarrays of length L
            for (int i = 0; i <= n - L; i++) {
                int j = i + L - 1; // End index of the subarray
                int max = Integer.MIN_VALUE; // Track the maximum coins
                
                // Try bursting each balloon in the range [i, j]
                for (int k = i; k <= j; k++) {
                    int leftBursted = 0;
                    int rightBursted = 0;
                    
                    // Get the coins from the left side if there's any
                    if (i <= k - 1) {
                        leftBursted = dp[i][k - 1];
                    }
                    
                    // Get the coins from the right side if there's any
                    if (k + 1 <= j) {
                        rightBursted = dp[k + 1][j];
                    }
                    
                    // Determine the left balloon's value
                    int leftN;
                    if (i == 0) {
                        leftN = 1;
                    } else {
                        leftN = nums[i - 1];
                    }
                    
                    // Determine the right balloon's value
                    int rightN;
                    if (j == n - 1) {
                        rightN = 1;
                    } else {
                        rightN = nums[j + 1];
                    }
                    
                    // Calculate the total coins by bursting the k-th balloon last
                    int curr = leftBursted + leftN * nums[k] * rightN + rightBursted;
                    
                    // Update max coins for this subarray [i, j]
                    max = Math.max(max, curr);
                }
                
                dp[i][j] = max; // Store the result in the dp table
            }
        }
        
        return dp[0][n - 1]; // Return the result for the full array
    }
}