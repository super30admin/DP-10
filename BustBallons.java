class Solution {
    //tc- o(n^3)
    //sc-o(n^2)
    public int maxCoins(int[] nums) {
        if(nums==null || nums.length == 0) return 0;
        int n = nums.length;
        int[][]dp = new int[n][n];

        for(int l =1;l<=n;l++)//l=1,2,3,4
        //for,m all the possible arrays pf that particular l
        {
            for(int i=0;i<=n-l;i++)//starting index of arrays
            {
                int j = i+l-1;//end idx

                for(int k=i;k<=j;k++ ){
                    //kth baloon burst at the end
                    //before +left*curr*right+after
                    int left =1;
                    int right =1;
                    if(j != n-1)
                    {
                        right = nums[j+1];
                    }
                    if(i!=0)
                    {
                        left = nums[i-1];
                    }
                    int before =0;
                    int after =0;
                    if(k!=i)
                    {
                        before = dp[i][k-1];
                    }
                    if(k!=j)
                    {
                        after = dp[k+1][j];
                    }
                    dp[i][j] = Math.max(dp[i][j], before + left*nums[k]*right + after);
                }
            
            }
        }
        return dp[0][n-1];
    }
}