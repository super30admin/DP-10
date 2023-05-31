// Approach 1
// Time Complexity -> O(n*n*k), n is the number of floors and k is the number of eggs.(TLE)
// Space Compelxity -> O(n*n*k), n is the number of floors and k is the number of eggs.
class Solution {
public:
    int superEggDrop(int k, int n) {
        vector<vector<int>> dp(k+1, vector<int>(n+1));
        for(int i = 1; i <= n; i++)
            dp[1][i] = i;
        
        for(int eggs = 2; eggs <= k; eggs++){
            for(int steps = 1; steps <= n; steps++){
                int val = INT_MAX;
                for(int currStep = 1; currStep <= steps; currStep++){
                    //             1 + max(breaks                ,   doesn't break)
                    val = min(val, 1 + max(dp[eggs-1][currStep-1], dp[eggs][steps-currStep]));
                }
                dp[eggs][steps] = val;
            }
        }
        return dp[k][n];
    }
};

// Approach 2
// Time Complexity -> O(n*k), n is the number of floors and k is the number of eggs.
// Space Compelxity -> O(n*k), n is the number of floors and k is the number of eggs.
class Solution {
public:
    int superEggDrop(int k, int n) {
        vector<vector<int>> dp(n+1, vector<int>(k+1));
        int attempts = 0;
 
        while(dp[attempts][k] < n){
            attempts++;
            for(int eggs = 1; eggs <= k; eggs++){
                //                  1 + breaks                + doesn't break
                dp[attempts][eggs] = 1 + dp[attempts-1][eggs-1] + dp[attempts-1][eggs];
            }
        }
        
        return attempts;
    }
};