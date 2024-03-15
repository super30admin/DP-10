class Solution {
    //TC: O(n^3)
    //SC: O(n*n)
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int [][] dp = new int[n][n];
        // Create length of subProblem
        for(int g = 0; g < n; g++){
            for(int i = 0, j = g; j < n; j++, i++){
                int max = Integer.MIN_VALUE;
                for(int k = i; k <=j ; k++)
                {
                    int left = k == i ? 0: dp[i][k-1];
                    int right = k == j ? 0 : dp[k+1][j];
                    int val = (i == 0 ? 1: nums[i-1]) * nums[k] * (j == n-1 ? 1 :nums[j+1]);
                    
                    int total = left + right + val;
                    max = Math.max(max,total);
                }
                dp[i][j] = max;
            }
        }


        return dp[0][n-1];
        

    }
}
