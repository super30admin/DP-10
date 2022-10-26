// Time Complexity : O(NxNxN)
// Space Complexity : O(NxNxN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int [][] dp = new int [n][n];
        for(int l=1;l<=n;l++){
            for(int i=0;i<=n-l;i++){
                int j = i+l-1; 
                for(int k =i;k<=j;k++){
                    int left=1;
                    int right=1;
                    int beforeLeft=0;
                    int beforeRight=0;
                    if (j != n-1){
                        right = nums[j+1];
                    }
                    if (i != 0){
                        left = nums[i-1];
                    }
                    if(i !=k){
                        beforeLeft = dp[i][k-1];   
                    }
                    if (k!=j){
                        beforeRight = dp[k+1][j]; 
                    }
                    dp[i][j] = Math.max(dp[i][j], beforeLeft+ left*nums[k]*right +beforeRight);
                }
            }
        }
        return dp[0][n-1];
    }
}