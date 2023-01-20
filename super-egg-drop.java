//tc is O(nk)
//sc is O(nk)
class Solution {
    public int superEggDrop(int k, int n) {
        if (k == 0 || n == 0)
            return 0;

        int[][] dp = new int[n + 1][k + 1];

        int attempts = 0;

        while (dp[attempts][k] < n) {
            attempts++;
            for (int j = 1; j < k + 1; j++) {
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j];
            }

        }

        return attempts;

    }
}