/* 
    Time Complexity                              :  superEggDropConventional - O(N^3)
                                                    optimization - O(N^2)
    Space Complexity                             :  O(N*K)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std; 


class Solution {
public:
    int superEggDrop(int k, int n) {
        // return superEggDropConventional(k,n);
        return optimization(k,n);
    }
    // 
    int superEggDropConventional(int k, int n) {
        if(k==0 or n == 0) return 0;
        vector<vector<int>> dp(k+1,vector<int>(n+1,0));
        // 1 egg case
        for(int j=1;j<=n;j++) {
            dp[1][j] = j;
        }
        int mn = INT_MAX;
        for(int i=2;i<=k;i++) {
            for(int j=1;j<=n;j++) {
                dp[i][j] = INT_MAX;
                for(int f=1;f<=j;f++) {
                    dp[i][j] = min(dp[i][j], 1 + max(dp[i-1][f-1],dp[i][j-f]));
                }
            }
            
        }
        return dp[k][n];
    }
    
    int optimization(int k, int n) {
        vector<vector<int>> dp(n+1,vector<int>(k+1,0));
        int attempts = 0;
        while(dp[attempts][k] < n) {
            attempts++;
            for(int j=1;j<=k;j++) {
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];
            }
        }
        return attempts;
        
    }
};

