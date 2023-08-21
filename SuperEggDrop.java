// // TC = O(n^2 x k) SC = O(nk)
// class Solution {
//     public int superEggDrop(int k, int n) {
//         int[][] dp = new int[k+1][n+1];
//         for(int i=1;i<=n;i++){
//             dp[1][i] = i;
//         }
//         for(int i=2;i<=k;i++){
//             for(int j=1;j<=n;j++){
//                 int min = Integer.MAX_VALUE;
//                 for(int f=1;f<=j;f++){
//                     min = Math.min(min,1+Math.max(dp[i-1][f-1],dp[i][j-f]));
//                 }
//                 dp[i][j] = min;
//             }
            
//         }
//         return dp[k][n];
//     }
// }

// // TC = O(nk) SC = O(nk)
// class Solution {
//     public int superEggDrop(int k, int n) {
//         int[][] dp = new int[n+1][k+1];
//         int attempts = 0;
//         while(dp[attempts][k] < n){ //here i is the number of attempts
//             attempts++;
//             for(int j=1;j<=k;j++){
//                 dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];
//             }
//         }
//         return attempts;
//     }
// }

// TC = O(nk) SC = O(n) -- optimised on space
class Solution {
    public int superEggDrop(int k, int n) {
        int[] dp = new int[k+1];
        int attempts = 0;
        while(dp[k] < n){ //here i is the number of attempts
            attempts++;
            int diagUp = 0;
            for(int j=1;j<=k;j++){
                int temp = dp[j];
                dp[j] = 1 + diagUp + dp[j];
                diagUp = temp;
            }
        }
        return attempts;
    }
}