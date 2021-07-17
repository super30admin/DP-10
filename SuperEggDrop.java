public class SuperEggDrop {

    // If we take one attempt with one egg,
    // Break: it will become 0 attempt and 0 egg
    // Doesn't break: it will become 0 attempt and 1 egg
    // dp[0][0] and dp[0][1] are the sub problems.

    // TC: O(NK)
    // SC: O(NK)
    public int superEggDrop(int K, int N) {

        // Attempts vs Eggs
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i < dp.length; i++) { // For each attempt
            for (int j = 1; j < dp[0].length; j++) { // Each Egg
                int breakChoice = dp[i - 1][j - 1];
                int doesntBreakChoice = dp[i - 1][j];
                dp[i][j] = 1 + breakChoice + doesntBreakChoice;

                // If i can reach the top floor or more then that will be the certainty floor.
                if (dp[i][K] >= N) {
                    return i;
                }
            }
        }
        return 0;
    }

    public int superEggDropBF(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];

        // First second row incremented values
        // With N egg, i will be reaching N attempts at the worst case
        for (int i = 1; i < dp[0].length; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                // i - egg
                // j - floor
                // k - limited floor - Checking in each floor
                // All permutations
                int min = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    // Breaks
                    int breakChoice = dp[i - 1][k - 1];
                    // Doesn't Break
                    int doesntBreakChoice = dp[i][j - k];

                    int currentMax = 1 + Math.max(breakChoice, doesntBreakChoice);
                    min = Math.min(min, currentMax);
                }
                dp[i][j] = min;
            }
        }

        return dp[K][N];
    }

    public static void main(String[] args) {
        SuperEggDrop superEggDropObj = new SuperEggDrop();
        superEggDropObj.superEggDrop(1, 2);
    }
}
