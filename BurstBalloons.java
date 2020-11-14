// Time Complexity : O(n^3)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// DP
class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int n = nums.length;
        
        int[][] dp = new int[n][n];
        
        for(int len=1; len<=n; len++){ // Size of ecision array
            for(int i=0; i<= n-len ; i++){ // (0, 3)
                int j= i + len - 1; // (0)
                for(int x=i; x<=j; x++){ //(0, 0)
                    //dp
                    int mul_left = 1;
                    int mul_right = 1;
                    int before = 0;
                    int after = 0;
                    
                    if(i!=0){
                        mul_left = nums[i-1];
                    }
                    if(j != n-1){
                        mul_right = nums[j+1];
                    } 
                    
                    //popilating before and after
                    if(x != i){
                        before = dp[i][x-1];
                    }
                    if(x != j){
                        after = dp[x+1][j];
                    }
                    
                    dp[i][j] = Math.max(dp[i][j], before + mul_left *nums[x]*
mul_right + after);
                }
            }
        }
        return dp[0][n-1];
        
    }
}