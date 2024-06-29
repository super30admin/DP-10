// Time Complexity : O(n^3)
// Space Complexity : O(n^2)
// Method used : DP

class Solution {

    public int maxCoins(int[] nums) {

        // This problem is variant of Matrix Chain Multiplication DP
        int[] new_array = new int[nums.length + 2];

        // Values for boundary cases
        new_array[0] = new_array[nums.length + 1] = 1;

        for(int i = 1; i <= nums.length; i++) new_array[i] = nums[i - 1];

        int n = nums.length;

        int[][] dp = new int[n + 2][n + 2];

        // In the function calls i value was 1 which which i started from 1 and went till n and similarly j value was n it means
        // j started from n and went till 1. As recursion is top down and tabulation is bottom up we change the variants for i and j
        for(int i = n; i >= 1; i--)
        {
            for(int j = 1; j <= n; j++)
            {
                // This was the same base case in recursion
                if(i > j) continue;

                int maximum = Integer.MIN_VALUE;

                // Any index could be the last balloon to burst. We are bursting balloons in reverse order. It's like we burst balloons 
                // like last balloon bursted then 2nd last balloon bursted etc...

                for(int index = i; index <= j; index++)
                {
                    maximum = Math.max(maximum, new_array[i - 1] * new_array[index] * new_array[j + 1] + dp[i][index - 1] + dp[index + 1][j]);
                }

                dp[i][j] = maximum;
            }
        }

        return dp[1][n];
    }
}
