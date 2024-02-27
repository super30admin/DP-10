// Time ComplexitY:  O(n^3)
// Space Complexity: O(n^2)

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int l=1; l<=n; l++) {                                                    // length of subarray
            for(int i=0; i<=n-l; i++) {
                int j = i+l-1;                                                       // end of subarray
                int maxVal = Integer.MIN_VALUE;
                for(int k=i; k<=j; k++) {                                            // last burst baloon index
                    // before + (left * nums[k] * right) + after
                    int left = 1, right = 1;
                    if(i != 0) left = nums[i-1];
                    if(j != n-1) right = nums[j+1];

                    int before = 0, after = 0;
                    if(k != i) before = dp[i][k-1];
                    if(k != j) after = dp[k+1][j];

                    maxVal = Math.max(maxVal, before+(left*nums[k]*right)+after);
                }
                dp[i][j] = maxVal;
            }
        }
        return dp[0][n-1];
    }
}
