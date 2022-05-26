//TC : O(n * k) For n  no. of attemps and k eggs, we will calculate max. of floors we can covers using n attempts.

//SC : O(k * n) -- DP matrix

//DP With OPtimization.
class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n+1][k+1];
        
        int attemps = 0;
        
        while(dp[attemps][k] < n){ // Calculate until No. of floors covered at p attemps and k eggs < total (n) no. of floors
            attemps++;
            for(int j = 1; j <= k; j++){
                dp[attemps][j] = 1 + dp[attemps - 1][j-1] + dp[attemps - 1][j];
                    //Break  -- 1 attempt is used and 1 egg broken      //No-Break -- 1 attempt is used and no eggs broken
            }
        }
        return attemps;
    }
}



/*
//TC : O(k * n * n) == O(k * n^2) --- For k eggs, iterating over n floors, checking possibility of for 1 to f floors for floor = f
//SC : O(k * n) -- DP matrix



//DP Failed.   What to do now?????????? ---- How we will Optimize this solution!!?
class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];
        
        for(int j = 1; j <= n; j++){
            dp[1][j] = j;
        }
        
        for(int i = 2; i < dp.length; i++){
            for(int j = 1; j< dp[0].length; j++){
                int min = Integer.MAX_VALUE;
                
                for(int floor = 1; floor <= j; floor++){
                    min = Math.min(min, 1 + Math.max( dp[i-1][floor-1] , dp[i][j-floor] ));
                }       // Break -- IF EGG broken, Explore floors below that floor       // No-Break cases IF EGG nt broken, Explore floors above that floor
                //Finding the best(min) of all worst case scenarios
                dp[i][j] = min;
            }
        }
        
        return dp[k][n];
    }
}

*/