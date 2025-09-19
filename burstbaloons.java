// Time Complexity: O(n^3) – iterate over all interval lengths and starts (O(n^2)), and for each interval try all k as the last balloon (O(n)).
// Space Complexity: O(n^2) – DP table dp[i][j] for all subarrays.

// Build interval DP: for each length le = 1..n and start i, set j = i+le-1 and try each k in [i..j] as the last balloon.
// Gain = dp[i][k-1] + nums[k] * (i>0? nums[i-1]:1) * (j<n-1? nums[j+1]:1) + dp[k+1][j]; update dp[i][j] with the max.

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
