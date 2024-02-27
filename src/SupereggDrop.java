// Time Complexity:  O(n*k)
// Space Complexity: O(n*k)

class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n+1][k+1];
        int attempts=0;
        while(dp[attempts][k] < n) {                                                                     // check whether attempts are correct as per eggs, and levels
            attempts++;
            for(int j=1; j<=k; j++) {
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];                           // sum up all attempts
            }
        }
        return attempts;
    }
}

// // ********** Conventional DP with all permutations **********
// // Time Complexity:  O(n*n*k)
// // Space Complexity: O(n*k)

// class Solution {
//     public int superEggDrop(int k, int n) {
//         int[][] dp = new int[k+1][n+1];
//         for(int j=1; j<=n; j++) 
//             dp[1][j] = j;
//         for(int i=2; i<=k; i++) {
//             for(int j=1; j<=n; j++) {
//                 dp[i][j] = Integer.MAX_VALUE;
//                 for(int floor=1; floor<=j; floor++) {                                                  // for all permutations
//                     dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i-1][floor-1], dp[i][j-floor]));     // taking minimum attempts
//                 }
//             }
//         }
//         return dp[k][n];
//     }
// }
