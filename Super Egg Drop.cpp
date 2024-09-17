// 9/9 class
//time: O(n*k)
//space: O(n*k)
class Solution {
public:
    int superEggDrop(int k, int n) {
        vector<vector<int>> dp(n+1, vector<int>(k+1));
        int attempts = 0;
        while(dp[attempts][k] < n) {
            attempts++;
            for(int j = 1; j <= k; j++) {
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];
            }
        }
        return attempts;
    }
};