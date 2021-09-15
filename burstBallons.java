
// 312. Burst Balloons : https://leetcode.com/problems/burst-balloons/
// Time Complexity : O(N * N-1)
// Space Complexity : O(N*N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for(int len = 1; len <= n; len++){
            //start index
            for(int i=0; i<= n-len; i++){
                //end index
                int j = i+len-1;
                //last ballon to burst
                for(int k=i; k<=j; k++){
                    int burstLeft =0, burstRight = 0;
                    if(k != i)
                        burstLeft = dp[i][k-1];
                    if( k != j)
                        burstRight = dp[k+1][j];
                    
                    int left = 1, right = 1;
                    if(i != 0)
                        left = nums[i-1];
                    if(j != n-1)
                        right = nums[j+1];
                    
                    dp[i][j] = Math.max(dp[i][j], burstLeft + left * nums[k] * right + burstRight);
                    
                }
            }
        }
        
        return dp[0][n-1];
    }
}