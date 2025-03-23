class Solution {
    //Time Complexity:O(n^3)
    //Space Complexity:O(n^2)
    int max =0;
    public int maxCoins(int[] nums) {
        if (nums.length ==0 )
        return 0;
        int n= nums.length;
        int[][] dp = new int [n][n];

        //going to give len of aryay
        for (int len =1; len<=n ;len++){
            for (int i =0; i<= n -len;i ++){
            int j = len +i -1;
            for (int k = i; k <= j;k ++){
                int left = 1;
                if (i!= 0)
                left = nums[i-1];
                int right = 1;
                if (j!=n-1)
                right = nums[j+1];
                int before =0;
                if (k!= i )
                before = dp[i][k-1];
                int after =0;
                if (k!= j )
                after = dp[k+1][j];
                dp[i][j] = Math.max (dp[i][j], before + left * nums[k] * right + after);
            }
        }
        
    }
        return dp [0][n-1];
}
}
