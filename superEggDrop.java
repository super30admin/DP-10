// Time Complexity = O(n*k)
// Space Complexity = O(n*k)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int superEggDrop(int k, int n) {
        if (n == 0) return 0;
        int[][] dp = new int[n+1][k+1];
        int attempts=0;

        while (dp[attempts][k] < n) {
            attempts++;
            for (int j=1; j<=k; j++) {
                // 1 is for the current attempt from the current floor + Break case + No Break case
                // we add these 3 entities because we calculate the no. of moves in all cases including current, break, and no break.
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];

                // as soon as we find a case where the no. of attempts exceed the no. of floors, we can return the attempts.
                if (dp[attempts][j] >= n) {
                    return attempts;
                }
            }
        }

        return -1;
    }
}