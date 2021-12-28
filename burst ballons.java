//Time complexity:- 0(N*N).
//space complexity:- O(N*n).



class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for(int g = 0;g<n;g++)
        {
            for(int i=0,j=g;j<n;i++,j++)
            {
                int max = Integer.MIN_VALUE;
                for(int k=i;k<=j;k++)
                {
                    int left = (k == i ? 0 : dp[i][k-1]);
                    int right = (k == j ? 0 : dp[k+1][j]);
                    int val = (i == 0?1:nums[i-1]) * nums[k] * (j == n-1 ? 1 : nums[j+1]);
                    int total = left+right+val; // based on choices and positions calculating total cost that means if previous ballon is bursted that cost or else zero, same as right will be updated if after ballon is bursted ading zero or else a value with dp matrix will be braught.In all possible methods returning a maximum of them.
                    max = Math.max(total,max);
                }
                dp[i][j] = max;
            }
        }
        
        return dp[0][n-1];
    }
}