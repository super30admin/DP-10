class Solution {
    // First DP soln gives TLE. eggs vs floors
    // public int superEggDrop1(int k, int n) {
        
    // }

    // Second DP - Attempts vs eggs - 
    public int superEggDrop(int k, int n) {
        // k = 3, n = 4
        // how many toal floors can i explore with this many attampts and this many eggs
        // total floors = 1 (current) + if  break + not break

        if (k == 0 || n == 0) {
            return 0;
        }

        int dp[][] = new int[n + 1][k + 1];

        int attempts = 0;

        while(dp[attempts][k] < n) { // go to next row only if with current attempts + max eggs, we can reach less than n floors. otherwise we can directly return the attempts.
            attempts++; // go to next row

            for (int j = 1; j < k + 1; ++j) {
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j];
            }

        }

        return attempts;
    }


}