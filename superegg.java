// Time Complexity: O(k * A) – where A is the returned minimal number of attempts; worst case O(k * n).
// Space Complexity: O(n * k) – dp table of size (n+1) × (k+1) (can be reduced to O(k) with rolling array).

// Reframe DP by attempts: let dp[a][e] = max floors we can cover with a attempts and e eggs.
// Increase attempts a until dp[a][k] ≥ n, using the transition dp[a][e] = 1 + dp[a-1][e-1] + dp[a-1][e].
// Return the smallest a that reaches/exceeds n.

class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n+1][k+1];

        int attempts = 0;

        while(dp[attempts][k] < n){
            attempts++;
            for(int j = 1; j <= k; j++){
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];
            }
        }

        return attempts;
    }
}
