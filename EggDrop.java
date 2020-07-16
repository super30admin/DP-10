// Time Complexity :
            /*           APPROACH 1 : USE DP: O(n^2 * k) where n is the number of floors and k is the number of eggs
                         APPROACH 2: USE OPTIMAL DP: O(nk) where n is the number of floors and k is the number of eggs
// Space Complexity : O(nk) for dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Requires Critical thinking
/* Your code here along with comments explaining your approach: Eggs below a threshold floor will not break and above that floor will surely break 
In DP approach, we start from the first floor and one egg check the number of attempts we took. Gradually, we increase it till N and K. But for
each of the floor, I check, what happens if the egg breaks (explore below floors) and what if the egg doesnt break (explore above floors). We check
it for each of the floor and for each floor we further check the situation from 1 to floor number. In Optimal DP, we are optimising this step and 
using attempts to calculate the number of floors required. We return the number of attempts once it becomes greater than N because we have reached
a point where N floors have been explored.
*/

// APPROACH 1 : USE DP
class Solution {
    public int superEggDrop(int K, int N) {
     if(N == 0 || K == 0) return 0;
      int[][] dp = new int[K+1][N+1];
      for(int i = 1; i < dp[0].length; i++)                                                     // For floor 1
          dp[1][i] = i;
       for(int k = 2; k < dp.length; k++){                                              // Start from floor 2 till N
          for(int n = 1; n < dp[0].length; n++){
              int min = Integer.MAX_VALUE;
              dp[k][n] = Integer.MAX_VALUE;                                                 
             for(int f = 1; f <= n; f++){                                               // For each floor N, the situation from 1 to Nth floor is
                 min = 1 + Math.max(dp[k-1][f-1], dp[k][n - f]);                // One egg is dropped, remaining attempt and floors to be explored when egg breaks and doesnt break
                 dp[k][n] = Math.min(min, dp[k][n]);                                                        // Keep the min number of attempts
             }    
          }
      }
        return dp[K][N];                                                        // Return the min number of attempts required
    }
}

// APPROACH 2: USE OPTIMAL DP
class Solution {
    public int superEggDrop(int K, int N) {
     if(N == 0 || K == 0) return 0;
      int[][] dp = new int[N+1][K+1];
      for(int i = 1; i < dp.length; i++){                                                           // Start from Attempt 1 till N attempts
          for(int j = 1; j < dp[0].length; j++){                                                    // For each attempts start from first egg till K eggs
              dp[i][j] = 1 + dp[i-1][j-1] + dp[i-1][j];                                             // Attempt made now + attempt remaining when egg broke + attempt remaining if egg doesnt break
              if(dp[i][j] >= N){return i;}                                                          // Once value exceed N floors => attempts esult is returned
          }
      }
      return 0;
    }
}