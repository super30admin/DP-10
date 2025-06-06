// Time Complexity : O(n^3)
// Space Complexity :O(n^2)
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n];

        for(int le=1; le<=n; le++){ // size of the burstible array
            for(int i=0; i<= n-le; i++){ // strat indices
                int j = i+le-1;
                for(int k=i; k<=j; k++){ // permutaion of bursting the ballons

                    // before + balloonItself + after
                    int before = 0, after = 0;

                    if(i != k)
                    {
                        before = dp[i][k-1];
                    }
                    if(j != k){
                        after = dp[k+1][j];
                    }
                    int prev = 1, next = 1;
                    if(i > 0){
                        prev = nums[i-1];
                    }
                    if(j < n-1){
                        next = nums[j+1];
                    }
                    int balloonItself = prev * nums[k] * next;

                    dp[i][j] = Math.max(dp[i][j], before + balloonItself + after);

                }
            }
            
        }
        return dp[0][n-1];
    }
}
