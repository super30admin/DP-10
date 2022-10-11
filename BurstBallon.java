// Time Complexity : O(n^3)
// Space Complexity : O(n*n)

class BurstBallon {
    public int maxCoins(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int n = nums.length;
        int[][] dp = new int[n][n];

        //taking each partition of array
        for(int l = 1; l<=n; l++){
            //starting index of partition
            for(int i=0; i<=n-l; i++){
                //last index
                int j=i+l-1;
                //kth positioned ballon will get burst in the end.
                for(int k=i; k<=j; k++){
                    //before + left*curr*right + after
                    int left = 1;
                    int right= 1;
                    if(i!=0){
                        left = nums[i-1];
                    }
                    if(j!=n-1){
                        right = nums[j+1];
                    }

                    int before = 0;
                    int after = 0;
                    if(k!=i){
                        before = dp[i][k-1];
                    }
                    if(k!=j){
                        after = dp[k+1][j];
                    }

                    dp[i][j] = Math.max(dp[i][j], before+(left*nums[k]*right)+after);
                }
            }
        }
        return dp[0][n-1];
    }
}