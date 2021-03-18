/*
method 1: use dp array of number of eggs vs number of floors
-for each egg, we check all the floors. 
-take the best case out of all worst case 
TC: O(n^2k)
Gives TLE

method 2: 
to use dp array but map number of attempts vs number of eggs.
Assuming in very worst case scenariio we will try all floors so dp[][ ] = new int[n+1][k+1]

we stop and return the result whenever number of floors goes beyond given 'n' in the dp array

TC: O(n*k)

*/
class Solution {
    public int superEggDrop(int k, int n) {
        
        
        //method 1: 
//         int[][]dp = new int[k+1][n+1];
        
//         for(int j = 1; j < dp[0].length;j++){
//             dp[1][j] = j;
//         }
//         for(int i = 2; i < dp.length;i++){
//             for(int j = 1; j < dp[0].length;j++){
//                 dp[i][j] = Integer.MAX_VALUE;
                
//                 for(int f = 1; f <= j;f++){
//                     dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i-1][f-1],dp[i][j-f]));
//                 }
//             }
//         }
        //method 2:
        int[][]dp = new int[n+1][k+1];
        int numOfAttempts =0;
        
        while(dp[numOfAttempts][k] < n){
            
           numOfAttempts++; //incrememting row
            for(int j = 1; j < dp[0].length;j++){
                dp[numOfAttempts][j] =  1 + dp[numOfAttempts-1][j-1] + dp[numOfAttempts-1][j];
            
            }
        }
        
        
        return numOfAttempts;
    }
}