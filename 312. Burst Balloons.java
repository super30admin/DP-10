class Solution {//time of O(N^3) and space of O(N^2)
    public int maxCoins(int[] nums) {
        
        int N = nums.length ;
        
        if(N==0) return 0;
        int[][] dp = new int[N][N];
        
        for(int len = 1 ; len<= N ; len++){
            for(int left =0 ; left<= N-len ; left++){
                int right = left + len - 1;
                for(int last=left; last<=right; last++){
                    int leftVal = 1;
                    int rightVal = 1;
                    if(left!=0){
                        leftVal = nums[left-1];
                    }
                    if(right!=N-1){
                        rightVal = nums[right+1];
                    }
                    int beforeWindow = 0;
                    int afterWindow = 0;
                    if(left!=last){
                        beforeWindow = dp[left][last-1];
                    }
                    if(right!= last){
                        afterWindow = dp[last+1][right];
                    }
                    dp[left][right]= Math.max(dp[left][right],beforeWindow + afterWindow+nums[last]*leftVal*rightVal);
                }
            }
        }
        return dp[0][N-1];
    }
}