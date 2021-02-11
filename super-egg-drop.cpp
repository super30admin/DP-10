//Time - O(KN)
//Space - O(KN)
class Solution {
public:
    int superEggDrop(int K, int N) {
        
        vector<vector<int>> dp(N+1, vector<int>(K+1,0));
        int attempts = 0;
        while(dp[attempts][K]<N){
            attempts++;
            for(int i = 1;i<=K;i++){
                dp[attempts][i] = 1 + dp[attempts-1][i-1] + dp[attempts-1][i];
            }
        }
        
        return attempts;
    }
};