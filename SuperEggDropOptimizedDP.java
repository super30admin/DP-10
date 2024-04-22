// TC - O(N*K)
// SC - O(N*K)

public class SuperEggDropOptimizedDP {
    class Solution {
        public int superEggDrop(int k, int n) {
            int attempts = n;
            int eggs = k;
            int minMoves = Integer.MAX_VALUE;
            // Max attempts can be equal to number of floors
            int[][] dp = new int[attempts + 1][eggs + 1];

            for (int currAttempt = 1; currAttempt <= attempts; currAttempt++) {
                for (int currEggs = 1; currEggs <= eggs; currEggs++) {
                    dp[currAttempt][currEggs] = 1 + dp[currAttempt - 1][currEggs - 1] + dp[currAttempt - 1][currEggs];
                }
                if (dp[currAttempt][eggs] >= n) {
                    minMoves = currAttempt;
                    break;
                }
            }

            return minMoves;
        }
    }
}
