/* 
    Time Complexity                              :  O(N^3)
    Space Complexity                             :  O(N*N)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  


class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> dp(n,vector<int>(n,0));
        
        for(int len = 1; len <=n; len++) {
            // start index of the subarray
            for(int i=0;i<=n-len;i++) {
                // end index of the subarray
                int j = i + len - 1;
                // iterate between the start and the end index in the array
                for(int k = i;k<=j;k++) {
                    int before = 0;
                    if(k != i) {
                        before = dp[i][k-1];
                    }
                    
                    int after = 0;
                    if(k != j) {
                        after = dp[k+1][j];
                    }
                    
                    int left = 1;
                    if(i != 0) {
                        left = nums[i-1];
                    }
                    
                    int right = 1;
                    if(j != n-1) {
                        right = nums[j+1];
                    }
                    
                    dp[i][j] = max(dp[i][j], before + left * nums[k] * right + after);
                }
            }
        }
        
        return dp[0][n-1];
    }
};