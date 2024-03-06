/*
// Time Complexity : o(N^3)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
from bottom up apporach going from the last ballon left to all the ballons

*/

#include<iostream>
#include<vector>

using namespace std;

// this one is using memorization 

class Solution {
    vector<vector<int>> dp_arr;
    int dp(int i,int j,vector<int>& nums){
        if(i>j) return 0;
        if(dp_arr[i][j]!=-1) return dp_arr[i][j];
        int maxi{INT_MIN};
        for(int idx{i};idx<=j;++idx){
            int cost = nums.at(i-1)*nums.at(idx)*nums.at(j+1) + dp(i,idx-1,nums) + dp(idx+1,j,nums);
            maxi = max(maxi,cost);
        }   
        return dp_arr[i][j] = maxi;
    }
public:
    int maxCoins(vector<int>& nums) {
        int n = nums.size();
        dp_arr.resize(n+1,vector<int>(n+1,-1));
        nums.push_back(1);
        nums.insert(nums.begin(),1);
        return dp(1,n,nums);
    }
};

//the one with tabulation 


class Solution{
public:
    int maxCoins(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> dp_arr(n+2,vector<int>(n+2,0));
        nums.push_back(1);
        nums.insert(nums.begin(),1);
        for(int i{n};i>=1;--i){
            for(int j{1};j<=n;++j)
            {
                if(i>j) continue;
                int maxi{INT_MIN};
                for(int idx{i};idx<=j;++idx){
                    int cost = nums.at(i-1)*nums.at(idx)*nums.at(j+1) + dp_arr.at(i).at(idx-1) + dp_arr.at(idx+1).at(j);
                    maxi = max(maxi,cost);
                }
                dp_arr[i][j] = maxi;
            }
        }
        return dp_arr.at(1).at(n);
    }
};