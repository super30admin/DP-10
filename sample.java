// Super Egg Drop
// Time Complexity : O(n^2)
// Space Complexity : O(n^2) for 2D-dp array

// Your code here along with comments explaining your approach
class Solution {
    public int superEggDrop(int K, int N) {
        // dp array
        int[][] dp = new int[N + 1][K + 1];
        
        int attempts = 0;
        while (dp[attempts][K] < N) {
            attempts += 1;
            for (int j=1; j<=K; j++) { // eggs
                // calculating curr
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j];
            }
        }
        
        return attempts;
    }
}

// Burst Balloons
// Time Complexity : O(n^2)
// Space Complexity : O(n^2) for 2D-dp array

// Your code here along with comments explaining your approach
class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int dp[][] = new int[nums.length][nums.length];

        // performing dp
        for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i <= nums.length - len; i++) {
                int j = i + len - 1;

                for (int k = i; k <= j; k++) {
                    int left = 1;
                    int right = 1;

                    if (i != 0) { // if left present
                        left = nums[i-1];
                    }

                    if (j != nums.length -1) { // if right present
                        right = nums[j+1];
                    }

                    int before = 0;
                    int after = 0;

                    if (i != k) { // if i == k
                        before = dp[i][k-1];
                    }

                    if (j != k) { // if j == k
                        after = dp[k+1][j];
                    }

                    // calculating max for current
                    dp[i][j] = Math.max(left * nums[k] * right + before + after, dp[i][j]);
                }
            }
        }

        return dp[0][nums.length - 1];
    }
}
