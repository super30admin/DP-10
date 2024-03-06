#include<iostream>
#include<vector>

using namespace std;

//time limit exceeded solution 

class Solution {
    void display(vector<vector<int>>& vec){
        for(vector<int>& v:vec){
            for(int ele:v){
                cout<<ele<<" ";
            }
            cout<<endl;
        }
    }
public:
    int superEggDrop(int k, int n) {
        // dp array to store the min number of tries
        // to find the actual floor
        // for given number of eggs k and floors n
        vector<vector<int>> dp(k+1,vector<int>(n+1,0));
        for(int i{};i<=n;++i){
            dp.at(1).at(i) = i;
        }
        for(int i{2};i<=k;++i){
            for(int j{1};j<=n;++j){
                int temp{INT_MAX};
                for(int l{1};l<=j;++l){
                    // you will throw that's one step
                    // it will break and not break . Two scenarios
                    // index = number of eggs left, number of floors above or below
                    int val = 1 + max(dp[i-1][l-1],dp[i][j-l]);
                    temp =  min(temp,val);
                }
                dp.at(i).at(j) = temp;
            }
        }
        //display(dp);
        return dp.at(k).at(n);
    }
};

//this solution is based on number of floors we can explore 
//with the given number of eggs and attempts;
