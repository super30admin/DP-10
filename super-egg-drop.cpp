// Time Complexity: O(K*N^2)
// Space Complexity: O(K*N) size of dp
// Did this code successfully run on Leetcode : Time Limit Exceeded
class Solution {
public:
    int superEggDrop(int K, int N) {
        vector<vector<int>> dp(K+1, vector<int>(N+1,0));
        for(int j = 1; j < N+1; j++)
            dp[1][j] = j;
        
        for(int i = 2; i < dp.size(); i++) { // O(K)
            for(int j = 1; j < dp[0].size(); j++) { // O(N)
                dp[i][j] = INT_MAX;
                for(int floor = 1; floor <= j; floor++) { // O(N)
                    dp[i][j] = min(dp[i][j], 1 + max(dp[i-1][floor-1], dp[i][j-floor]));
                }
            }
        }
        return dp[K][N];
    }
};

// Time Complexity: O(K*N)
// Space Complexity: O(K*N)
class Solution {
public:
    int superEggDrop(int K, int N) {
        vector<vector<int>> dp(N+1, vector<int>(K+1,0));
        int attempts = 0;
        while(dp[attempts][K] < N) { // O(N)
            attempts++;
            for(int i = 1; i < K+1; i++) { // O(K)
                dp[attempts][i] = 1 + dp[attempts-1][i-1] + dp[attempts-1][i];
            }
        }
        return attempts;
    }
};

// Using 1-D dp vector
class Solution {
public:
    int superEggDrop(int K, int N) {
        vector<int> dp(K + 1, 0);
        int m = 0;
        while(dp[K] < N) {
            for (int k = K; k > 0; --k)
                dp[k] += dp[k - 1] + 1;
            m++;
        }
            
        return m;
    }
};
