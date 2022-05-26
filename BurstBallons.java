//TC : For creting sub-problem O(N), Iterating over those subproblems in O(N) and deciding which  ballon is bursted at the end in O(N) -- So total : O(N^3)


//SC : O(N^2) // Mainitning 2D DP array
class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        
        int n = nums.length;
        
        int[][] dp = new int[n][n];
        
        //Subproblem of len = 1, 2, 3, 4 .... n
        
        for(int length = 1; length <= n; length++){
            for(int i = 0; i <= n - length; i++){ // start index of subproblem
                int j = i + length - 1; // Which is last index of subproblem
                
                for(int k = i; k <= j; k++){ // If element at index k is bursted at the end
                    int before = 0, after = 0; // No baloon in left and right
                    
                    if(i != k){ 
                        before = dp[i][k-1];
                    }
                    // If there is ballon in left, update the coins earned
                    
                    
                    //If Ballon in right, update the coins earned
                    if(k != j){
                        after = dp[k+1][j];
                    }
                    
                    
                    int left = 1, right = 1;   
                    
                    if(i != 0){
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