import java.util.Arrays;

/**
 * Time Complexity: O(n^3)
 * Space Complexity: O(n^2)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Start by picking the last number - that is bottom up approach
 */

public class BurstBalloons {
    // --------- Approach 1 - Memoization ---------------
    int[] newNums;
    int[][] memo;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;

        memo = new int[n + 1][n + 1];

        for (int i = 0 ; i < n + 1; i++) {
            Arrays.fill(memo[i], -1);
        }

        int i = 1;
        for (int num: nums) {
            newNums[i++] = num;
        }

        return recurse(1, n);
    }

    private int recurse(int i, int j) {
        // base
        if (i > j) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // logic
        int max = 0;
        for (int index = i; index <= j; index++) {
            int cost = (newNums[i - 1] * newNums[index] * newNums[j + 1]) +
            recurse(i, index - 1) + recurse(index + 1, j);

            max = Math.max(max, cost);
        }

        memo[i][j] = max;

        return max;
    }

    // ----------- Approach 2 - Tabulation -----------------------
    public int maxCoins2(int[] nums) {
        int n = nums.length;
        newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;

        int[][] dp = new int[n + 2][n + 2];

        int k = 1;
        for (int num: nums) {
            newNums[k++] = num;
        }

        for (int i = n; i > 0; i --) {
            for (int j = 1; j <= n ; j++) {
                if (i > j) {
                    continue;
                }
                int max = 0;
                for (int index = i; index <= j; index++) {
                    int cost = (newNums[i - 1] * newNums[index] * newNums[j + 1]) +
                    dp[i][index - 1] + dp[index + 1][j];

                    max = Math.max(max, cost);
                }

                dp[i][j] = max;
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        // Your code here
    }
}