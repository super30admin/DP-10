// TC - O(k*n*n) => Time Limit Exceeded
// SC - O(k*n)

public class SuperEggDropDP {
    class Solution {
        public int superEggDrop(int k, int n) {
            int[][] dp = new int[k + 1][n + 1];

            for (int j = 1; j <= n; j++) {
                dp[1][j] = j;
            }

            for (int eggs = 2; eggs <= k; eggs++) {
                for (int floors = 1; floors <= n; floors++) {
                    int minMoves = Integer.MAX_VALUE;
                    for (int currFloor = 1; currFloor <= floors; currFloor++) {
                        int currMoves = 1 + Math.max(dp[eggs - 1][currFloor - 1], dp[eggs][floors - currFloor]);
                        minMoves = Math.min(currMoves, minMoves);
                    }
                    dp[eggs][floors] = minMoves;
                }
            }

            return dp[k][n];
        }
    }
}
