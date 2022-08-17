// approch 1 (TLE)
// Time Complexity : O(n^2k)
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2 
// Time Complexity : O(nk)
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Main {

    // approch 1 using dp matrix with trying all the possible cases
    public static int superEggDrop1(int k, int n) {
        // 0 floor case
        if (n == 0)
            return 0;
        // dp matrix
        int[][] dp = new int[k + 1][n + 1];
        // fill row 1 with number of floors
        for (int j = 1; j <= n; j++) {
            dp[1][j] = j;
        }
        // try all the possible permutation to find minimum number
        // of moves
        for (int i = 2; i <= k; i++) {
            // i -> number of eggs
            for (int j = 1; j <= n; j++) {
                // j-> number of floors
                int min = Integer.MAX_VALUE;
                for (int f = 1; f <= j; f++) {
                    // k-> all the possibilites of droping floor of the eggs
                    min = Math.min(min, 1 + Math.max(dp[i - 1][f - 1], dp[i][j - f]));
                }
                // minimum number of moves
                dp[i][j] = min;
            }
        }
        return dp[k][n];
    }

    // approch 2 using dp matrix with finding maximum number of
    // floors with moves and egs
    public static int superEggDrop2(int k, int n) {
        // 0 floor case
        if (n == 0)
            return 0;
        // dp matrix
        int[][] dp = new int[n + 1][k + 1];
        // intially number of moves will be 1
        int moves = 0;
        // while maximum floor we can get from certain
        // moves is less than input floors
        while (dp[moves][k] < n) {
            // increase moves by 1
            moves++;
            // trying maximum floor with the help 1 -> k eggs
            for (int i = 1; i <= k; i++) { // i-> number of eggs
                dp[moves][i] = 1 + dp[moves - 1][i - 1] + dp[moves - 1][i];
            }

        }
        return moves;
    }

    public static void main(String[] args) {
        int n = 1000;
        int k = 9;
        System.out.println(superEggDrop1(k, n));
        System.out.println(superEggDrop2(k, n));

    }
}