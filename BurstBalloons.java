// Time Complexity - O(n^3)
// Space Complexity - O(n)
// Approach
// After every number, we are creating subarray starting from length 1 to nums length and then
// we are considering each num what if the considered num balloon is burst at the end. So the sub problems
// we got while bursting the balloons one by one considering them to be burst at the end, those intermediate results will be
// pivotal. Subarray allows us to consider different permutations possible and to get the burst val that are
// not considered in subarray for particular momemnt. Then we keep max of burst val. We get burst val from dp array and we 
// consider each ele to be burst at the end, which means the rest of the balloons considered on subarray has already been burst

class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length][nums.length];                                                
        for(int sub = 1; sub <= nums.length; sub++){                                           
            for(int i = 0; i <= nums.length-sub; i++){                                              
                int j = i + sub-1;                                                                     
                int k  = i;
                while(k <= j){                                                                          
                    int left = 1, right = 1;                
                    if(i != 0)
                        left = nums[i - 1];                                                                 
                    if(j != nums.length-1)
                        right = nums[j + 1];                                            
                    int before = 0, after  = 0;
                    if(k != i){
                        before = dp[i][k-1];                                                         
                    }
                    if(k != j){
                        after = dp[k+1][j];                                                             
                    }
                dp[i][j] = Math.max(dp[i][j], before + left * nums[k] * right + after);                                 
                k++;                                                                                   
            }
        }
    }
        return dp[0][nums.length-1];                     
    }
}