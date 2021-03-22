// //TC: O(N*K) -> N: no.of floors, K: no.of eggs
// //SC: O(N*K)  -> N: no.of floors
// // Did it run successfully on Leetcode? : Yes
class Solution {
    public int superEggDrop(int k, int n) {
        int attempts = 0;
        int[][] dp = new int[n+1][k+1];
        while(dp[attempts][k] < n) {   
             attempts++;
            for(int j = 1; j <= k; j++) {
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];
            } 
        }
        return attempts;
    }
}

//TC: O(N*K*N) -> N: no.of floors, K: no.of eggs
//SC: O(N*K)  -> N: no.of floors
// Did it run successfully on Leetcode? : TLE
// class Solution {
//     public int superEggDrop(int k, int n) {
//         int[][] dp = new int[k+1][n+1];
//         for (int j = 1; j < dp[0].length; j++)
//         {
//             dp[1][j] = j;
//         }
//         for ( int i = 2; i < dp.length; i++)
//         {
//             for (int j = 1; j < dp[0].length; j++)
//             {
//                 dp[i][j] = Integer.MAX_VALUE;
//                 for (int l = 1; l <=j; l++)
//                 {
//                     dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i-1][l-1], dp[i][j-l]));
//                 }
//             }
//         }
//         return dp[ol];
//     }
// }
