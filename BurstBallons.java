class Solution {
    public int maxCoins(int[] nums) {
        //Sanity Check
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for(int len = 1; len <= n; len++){// for all possible lengths
            for(int i = 0; i <= n - len; i++){//all internal possible combinations
                int j = i + len - 1;
                
                for(int burst = i; burst <= j; burst++){
                    int before = 0;
                    int after = 0;
                    int mulLeft = 1;
                    int mulRight = 1;
                    
                    //calculating left multiplication factor
                    if(i != 0){
                        mulLeft = nums[i - 1];
                    }
                    if(j != n -1){//calculating right multiplication factor
                        mulRight = nums[j + 1];
                    }
                    //cost of bursting before part
                    if(burst != i){
                        before = dp[i][burst - 1];
                    }
                    if(burst != j){//cost of bursting after part
                        after = dp[burst+1][j];
                    }
                    
                    dp[i][j] = Math.max(dp[i][j], before + mulLeft *nums[burst] * mulRight + after);
                }
            }
        }
        
        //return final option of bursting all balloons
        return dp[0][n-1];
    }
}

//Time Complexity: O(n^3)
//Space Complexity: O(n^2)