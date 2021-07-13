//Time Complexity : O(n*n*k)
//Space Complexity : O(n*n)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : no
class Solution {
    public int maxCoins(int[] nums) {
        
        //Base case
        if(nums.length == 0 || nums == null){
            
            return 0;
        }
        
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        //len = taking single, double, triple set of baloons
        //i = start index
        //j = last index
        //Using dp to calculate the highest coins possible at each index
        for(int len = 1; len <= n; len ++){
            
            for(int i = 0; i <= n - len; i ++){
                
                int j = i + len - 1;
                int max = 0;
                
                for(int k = i ; k <= j ; k ++){//k = last balloon we are bursting
                    
                    int before = 0;
                    
                    if(k != i){//if k is not the first index of the burstible balloon
                        
                        before = dp[i][k-1];
                    }
                    int after = 0;
                    if(k != j){//if k is not the last index of the burstible balloon
                        
                        after = dp[k+1][j];
                    }
                    int left = 1;
                    int right = 1;
                    
                    if(i != 0){
                        
                        left = nums[i - 1];
                    }
                    if(j != n-1){
                        
                        right = nums[j + 1];
                    }
                   max = Math.max(max, before + left * nums[k] * right + after);
                   
                }
                
                 dp[i][j] = max;
            }
            
            
        }
        
        return dp[0][n-1];
    }
}