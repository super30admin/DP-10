//TC - O(n^3)
class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        int n = nums.length;
        
        int[][] dp = new int[n][n];
        for(int length = 1; length <= n; length++){
            for(int i = 0; i <= n - length; i++){ 
                int j = i + length - 1; 
                
                for(int k = i; k <= j; k++){ 
                    int before = 0, after = 0;
                    
                    if(i != k){ 
                        before = dp[i][k-1];
                    }
                    if(k != j){
                        after = dp[k+1][j];
                    }
                    int left = 1, right = 1;   
                    
                        left = nums[i-1];
                    }
                    if(j != n-1){
                        right = nums[j+1];
                    }
                    dp[i][j] = Math.max(dp[i][j], before +  (left * nums[k] * right)  + after);
                }
            }
        }
        return dp[0][n-1];
    }
}
