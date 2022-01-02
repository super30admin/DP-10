// Time Complexity : O(n*n*n)
// Space Complexity :O(n*n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// create an n*n matrix and go through each possible len array first ( starting with min value), in that find the max value for each balloon busrted at the end with the help of k pointer, the max value contians before burst, during burst(end) and after burst. Before burst is dp[i][k-1] if k != i, similarly after burst is dp[k+1][j] if k!= j. and to get the end value take the adjacent values of k pointer, if at the border take 1. return top left of the dp matrix as result.
// Your code here along with comments explaining your approach
class Solution {
    public int maxCoins(int[] nums) {
        if( nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int [][] dp = new int [n][n];
        // get lenght of lookup array
        for(int len = 1; len <= n; len++){
            // starting index of the array
            for(int i = 0; i <= n-len; i++){
                // ending index;
                int j = i + len - 1;
                // the index of the balloon which can burst at the end in the lookup array
                for(int k = i; k <= j; k++){
                    // before
                    int before = 0;
                    if( i != k ){
                        before = dp[i][k-1];
                    }
                    // after
                    int after = 0;
                    if( j != k){
                        after = dp[k+1][j];
                    }
                    // end balloon
                    int first = 1;
                    int last = 1;
                    if(i != 0){
                        first = nums[i-1];
                    }
                    if(j != n-1){
                        last = nums[j+1];
                    }
                    dp[i][j] = Math.max(dp[i][j], before+(first*nums[k]*last)+after);
                }
            }
        }
        return dp[0][n-1];
    }
}