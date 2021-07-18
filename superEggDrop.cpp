// Time : O(n^2 * k)
//Space : O(n*k)
// class Solution {
// public:
//     int superEggDrop(int k, int n) {
//         vector<vector<int>> dp(k+1,vector<int>(n+1,0));
//         for(int i = 1;i <=n;i++){
//             dp[1][i] = i;
//         }
//         for(int i = 2; i <=k;i++){
//             for(int j = 1;j<=n;j++){
//                 int minVal = INT_MAX;
//                 for(int floor = 1;floor <=j;floor++){
//                     minVal = min(minVal, 1 + max(dp[i-1][floor-1],dp[i][j-floor])); // max(break case(if broke explore below if any), non break case(if not break explore above floors for breaks))
//                 }
//                 dp[i][j] = minVal;
//             }
//         }
//         return dp[k][n];
//     }
// };

//Optimal Approach
//Time: O(nk)
//Space: O(nk)
class Solution {
public:
    int superEggDrop(int k, int n) {
        int attempts = 0;
        vector<vector<int>> dp(n+1,vector<int>(k+1,0));
        while(dp[attempts][k] < n){
            attempts++;
            for(int j = 1; j <= k; j++){
                dp[attempts][j] = 1 + dp[attempts-1][j-1]+dp[attempts-1][j];
            }
        }
        return attempts;
    }
};