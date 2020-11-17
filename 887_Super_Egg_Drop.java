    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/super-egg-drop/
    Time Complexity for operators : o(n*K) 
    Extra Space Complexity for operators : o(n*K) 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) 
    */ 

class Solution {
    public int superEggDrop(int K, int N) {
   
        // got TLE for below solution
        
//         int dp[][] = new int[K+1][N+1];
        
//         // first populate row
//         for(int j = 1; j <= N; j++){
//             dp[1][j] = j;
//         }
        
//         // dp two for loops
//         for(int i = 2; i <=K; i++){
//             for(int j = 1; j <= N; j++){
//                 dp[i][j] = Integer.MAX_VALUE;
                
//                 for(int floor = 1; floor <= j; floor++){
//                     dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i-1][floor-1], dp[i][j - floor]));
//                 }
//             }
//         }
        
//         return dp[K][N];
        
        
        int dp[][] = new int[N+1][K+1];
        int attempts = 0;
        while(dp[attempts][K] < N){// min attemps <= N
            attempts += 1;
            
            for(int j = 1; j <= K;j++){ // eggs
                dp[attempts][j] = 1 + dp[attempts-1][j - 1] + dp[attempts-1][j];
            }
        }
        
        return attempts;
    }
}