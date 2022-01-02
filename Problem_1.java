// Time Complexity : O(k*n)
// Space Complexity :O(k*n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// select the number of attempts and eggs we have, for each case there will be 2 case break and no break, add both and add with 1;
// Your code here along with comments explaining your approach
class Solution {
    public int superEggDrop(int k, int n) {
        // attempts on row
        int [][] dp = new int [n+1][k+1];
        boolean flag = false;
        // i = attempt
        for(int i = 1; i <=n; i++){
            //j = eggs remaining
            for(int j = 1; j <=k; j++){
                // break condition  //nobreak condition
                dp[i][j] = 1 + dp[i-1][j-1] + dp[i-1][j];
                // if found the attemps value is more then or equal to total possible values, return
                if(dp[i][j] >= n){
                    flag = true;
                    break;
                }
            }
            if(flag){
                return i;
            }
        }
        return n;
    }
}

// DP-Soluation but throws time limit exceed
// for break condition = dp[number of remaining][ number of rows below(visited)]
// for no break condition = dp [number of eggs][number of rows above(remaining)]
// class Solution {
//     public int superEggDrop(int k, int n) {
//         int [][] dp = new int [k+1][n+1];
//         // top col - for default result
//         for(int j = 1; j < dp[0].length; j++){
//             dp[1][j] = j;
//         }
//         // all
//         for(int i = 2; i < dp.length; i++){
//             for( int j = 1; j < dp[0].length; j++){
//                 dp[i][j] = Integer.MAX_VALUE;
//                 for(int f = 1; f <= j; f++){
//                     dp[i][j] = Math.min(dp[i][j],       1+ Math.max( dp[i-1][f-1], dp[i][j-f]));
//                                         // old value                  break , non-break
//                                         // of levels
//                 }
//             }
//         }
//         return dp[k][n];
//     }
// }

