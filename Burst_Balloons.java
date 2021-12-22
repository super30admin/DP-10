class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        
        int n = nums.length;
        int [][] dp = new int[n][n];
        
        for(int len = 1; len <= n; len++){
            for(int i = 0; i <= n - len; i++){
                int j = i + len - 1;
                int max = 0;
                
                for(int k = i; k <= j; k++){
                    int before = 0;
                    
                    if(k != i){
                        before = dp[i][k-1];
                    }
                    int after = 0;
                    if(k != j){
                        after = dp[k+1][j];
                    }
                    
                    int left = 1;
                    if(k != j){
                        after = dp[k+1][j];
                    }
                    
                    left = 1;
                    int right = 1;
                    
                    if(j != n-1){
                        right = nums[j+1];
                    }
                    if( i != 0){
                        left = nums[i-1];
                    }
                    
                    max = Math.max(max, before + left* nums[k] * right + after);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n-1];
    }
}

//TC: O(n^3)
//SC: O(n^2)
