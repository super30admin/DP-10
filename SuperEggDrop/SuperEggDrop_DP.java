/* Time Complexity : O((n^2)*k) 
 *  n - no. of floors */
/* Space Complexity : O(n*k)
 * k - no. of eggs */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : TLE


class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];
        //Populating row with one egg
        for(int j = 1; j <= n; j++){
            dp[1][j] = j;
        }
        //Populating col with one floor
        for(int i = 1; i <= k; i++){
            dp[i][1] = 1;
        }

        //i: range for eggs
        for(int i = 2; i <= k; i++){
            //i: range for floors
            for(int j = 2; j <= n; j++){
                int min = Integer.MAX_VALUE;
                for(int f = 1; f <= j; f++){
                    // curr no. of moves = 1 + Max(break, not broken)
                    //break = dp[eggs left][row/floors below curr row/floor]
                    //not broken = dp[total eggs][row/floors above curr row/floor]
                    int currMoves = 1 + Math.max(dp[i-1][f-1], dp[i][j-f]);
                    min = Math.min(min, currMoves);
                }
                dp[i][j] = min;
            }
        }
        return dp[k][n];
    }
}