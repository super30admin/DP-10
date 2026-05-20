/**
 * Super Egg Drop (LeetCode 887)
 *
 * Insight:
 * Instead of minimizing moves for n floors, we compute max floors
 * that can be checked with m moves and k eggs.
 * We increase moves until we can cover n floors.
 *
 * Time Complexity: O(k * moves) ~ O(k log n)
 * Space Complexity: O(k)
 */

public class SuperEggDrop {

    public int superEggDrop(int k, int n) {

        // dp[i] = max floors that can be tested with i eggs and current moves
        int[] dp = new int[k + 1];

        int moves = 0;

        // keep increasing moves until we can check at least n floors
        while (dp[k] < n) {
            moves++;

            // update backwards to avoid overwriting states
            for (int eggs = k; eggs > 0; eggs--) {
                dp[eggs] = dp[eggs] + dp[eggs - 1] + 1;
            }
        }

        return moves;
    }
}