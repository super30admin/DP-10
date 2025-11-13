#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We break the problem into smaller burstible ranges and solve each using dynamic programming
For each burstible array, we try every balloon as the last one to burst and compute the total coins
This way, we build up the best results for all ranges and get the final answer from the full range.
*/
class Solution{
public:
    int maxCoins(vector<int>& nums){
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for(int le = 1; le <= n; le++){
            for(int i = 0; i <= n-le; i++){
                int j = i + le -1;
                for(int k = i; k <= j; k++){
                    int before = (i != k) ? dp[i][k-1] : 0;
                    int after = (j != k) ? dp[k+1][j] : 0;

                    int prev = (i > 0) ? nums[i-1] : 1;
                    int next = (j < n-1) ? nums[j+1] : 1;

                    int balloonItself = prev*nums[k]*next;
                    dp[i][j] = max(dp[i][j], before + balloonItself + after);
                }
            }
        }
        return dp[0][n-1];
    }
};
