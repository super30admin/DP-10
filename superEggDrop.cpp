#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We define dp[i][j] as the max floors we can check with i attempts and j eggs.
For each attempt, we use the formula: 1 + below + above to get the new range
We keep going until we can cover at least n floors, then return the attempt count.
*/
class Solution{
public:
    int superEgg(int k, int n){
        vector<vector<int>> dp(n + 1, vector<int>(n+1, 0));
        int attempts = 0;

        while(dp[attempts][k] < n){
            attempts++;
            for(int j = 1; j <= k; j++){
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];
            }
        }
        return attempts;
    }
};
