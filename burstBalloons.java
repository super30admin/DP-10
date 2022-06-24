/*
Problem: https://leetcode.com/problems/burst-balloons/
TC: O(n^3)
SC: O(n^2)
*/
class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int n = nums.length;
        int dp[][] = new int[n][n];
        
        for (int length = 1; length <= n; ++length) {
            for (int start = 0; start <= n - length; ++start) {
                int end = start + length - 1;
                int maxProduct = 0;
                
                for (int balloonIndex = start; balloonIndex <= end; ++balloonIndex) {
                    int before = 0;
                    int after = 0;
                    
                    // Amount earned by bursting balloons BEFORE the balloons chosen in the current iteration from start - end
                    if (balloonIndex != start) {
                        before = dp[start][balloonIndex - 1];
                    }
                    
                    // Amount earned by bursting balloons AFTER the balloons chosen in the current iteration from start - end
                    if (balloonIndex != end) {
                        after = dp[balloonIndex + 1][end];
                    }
                    
                    // Cost of bursting balloon immediately to the LEFT of current balloon
                    int leftValue = 1;
                    int rightValue = 1;
                    
                    if (start - 1 >= 0) {
                        leftValue = nums[start - 1];
                    }
                    
                    // Cost of bursting balloon immediately to the RIGHT of current balloon
                    if (end + 1 < n) {
                        rightValue = nums[end + 1];
                    }
                    
                    dp[start][end] = Math.max(dp[start][end], before + leftValue * nums[balloonIndex] * rightValue + after);
                }
            }
        }
        
        return dp[0][n - 1];
    }
}