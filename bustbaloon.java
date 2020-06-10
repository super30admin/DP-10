// Time Complexity : O(n^3)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        int m = nums.length;
        int [][] dp = new int[m][m];
        for(int len = 1;len<=m;len++)
        {
            for(int i = 0; i <= m - len;i++)
            {
                int j = i+len -1;
                for(int k =i; k <=j;k++)
                {
                    int left = 1,right=1;
                    int before =0,after =0;
                    if(i!=0)
                    {
                        left = nums[i-1];
                    }
                    if(j!=m-1)
                    {
                       right =  nums[j+1];
                    }
                    if(k!=i)
                    {
                        before = dp[i][k-1];
                    }
                    if(k!=j)
                    {
                        after = dp[k+1][j];
                    }
                    
                    dp[i][j] = Math.max(dp[i][j], before + left*nums[k]*right +after);
                }
            }
        }
        return dp[0][m-1];
    }
}