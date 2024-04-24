class Solution {
    public int maxCoins(int[] nums) {
        int [][]dp = new int[nums.length][nums.length];
        for(int l=1; l<=nums.length;l++) {

            for(int i=0; i<=nums.length-l;i++) {
                int j = i+l-1;
                for(int k = i; k <= j;k++) {
                    int previous=0;
                    if(k != i) {
                        previous = dp[i][k-1];
                    }
                    int after = 0;
                    if(k != j) {
                        after = dp[k+1][j];
                    }
                    int left =1;
                    if(i!=0) {
                        left = nums[i-1];
                    }

                    int right = 1;
                    if(j != nums.length-1) {
                        right = nums[j+1];
                    }
                    int value = previous+ left*nums[k]*right+after;
                    dp[i][j] = Math.max(dp[i][j], value);
                }
            }
        }
        return dp[0][nums.length-1];
    }
}