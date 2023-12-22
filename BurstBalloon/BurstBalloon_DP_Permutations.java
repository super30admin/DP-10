/* Time Complexity : O(n^3) 
 *  n - len. of nums array */
/* Space Complexity : O(n^2) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//DP - Permutation

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        //Burstible array length range from 1 to n
        for(int le = 1; le <= n; le++){
            //start idx of burstible array range from o to n-le
            for(int i = 0; i <= n-le; i++){
                //end idx of burstible array
                int j = i + le - 1;
                int max = 0;
                //Burstible array from i to j, consider bursting each balloon at the end
                for(int k = i; k <= j; k++){
                    //burst at end = before + left*currIdxVal*right + after
                    int before = 0;
                    if(i != k){
                        before = dp[i][k-1];
                    }
                    int after = 0;
                    if(j != k){
                        after = dp[k+1][j];
                    }
                    int left = 1;
                    if(i != 0){
                        left = nums[i-1];
                    }
                    int right = 1;
                    if(j != n-1){
                        right = nums[j+1];
                    }
                    max = Math.max(max, before + left*nums[k]*right + after);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n-1];
    }
}