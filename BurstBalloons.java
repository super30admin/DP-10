// Time Complexity : O(n^3)
// Space Complexity : O(n^2) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int maxCoins(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int n=nums.length;
        int[][] dp=new int[n][n];
        
        for(int len=1;len<=n;len+=1){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                
                for(int x=i;x<=j;x++){
                    int mul_left=1; int mul_right=1;
                    int before=0; int after=0;
                    
                    if(i!=0){
                        mul_left=nums[i-1];
                    }
                    if(j!=n-1){
                        mul_right=nums[j+1];
                    }
                    if(x!=i){
                        before=dp[i][x-1];
                    }
                    if(x!=j){
                        after=dp[x+1][j];
                    }
                    dp[i][j]=Math.max(dp[i][j],before+mul_left*nums[x]*mul_right+after);
                }
            }
        }
        return dp[0][n-1];
    }
}