// Time - O(n^3) - where n is the number of elements in the vector
// Space - O(n^2) - DP Matrix
// Approach - Explore all possible options using top down DP considering a particular ballon is burst last in all possible cases with all permutations
class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int n = nums.size();
        int dp[n][n];
        for(int len = 1; len <= n;len++){
            for(int i = 0; i <= n-len;i++){
                int j = i + len -1;
                int maxVal = 0;
                for(int k =i;k<=j;k++){
                    int before = 0;
                    if(k != i){
                        before = dp[i][k-1]; //Value until before burst on the left side of array
                    }
                    int after = 0;
                    if(k != j){
                        after = dp[k+1][j]; // Value until before burst on the right side of array
                    }
                    int left = 1;
                    int right = 1;
                    if(i != 0) left = nums[i-1]; //Val in left not yet burst
                    if(j != n-1) right = nums[j+1]; //Val in right not yet burst which contributes to curr ballon burst
                    maxVal = max(maxVal,before + (left*nums[k]*right) +after);
                }
                dp[i][j] = maxVal;
            }
        }
        return dp[0][n-1];
    }
};