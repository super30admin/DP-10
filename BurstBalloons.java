// Time Complexity : O(n^3) where n is the number of elements in array
// Space Complexity : O(n) for dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Hard problem to grasp
/* Your code here along with comments explaining your approach: Afor every number, we are creating subarray starting from length 1 to 
nums length and then we are considering each number what if the considered number balloon is burst at the end. So the sub problems we got while
bursting the balloons one by one considering them to be burst at the end , those intermediate results will be pivotal. Subarray allows us to consider
different permutations possible and to get the burst value that are not considered in the subarray for the particular moment. then we keep the max
of the burst value. We get the burst value from the dp array and we consider each element to be burst at the end, which means the rest of the ballons
considered in subarray has already been burst.
*/
class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length][nums.length];                                                 // Dp with indexes
        for(int sub = 1; sub <= nums.length; sub++){                                            // For each subarray
            for(int i = 0; i <= nums.length-sub; i++){                                              // the subarray starting index
                int j = i + sub-1;                                                                      // Subarray ending index
                int k  = i;
                while(k <= j){                                                                          // Iterating over the subarray
                    int left = 1, right = 1;                                                            // left and right in product 
                    if(i != 0)
                        left = nums[i - 1];                                                                 // Take the left of start value
                    if(j != nums.length-1)
                        right = nums[j + 1];                                                            // Take right of the end value
                    int before = 0, after  = 0;
                    if(k != i){
                        before = dp[i][k-1];                                                            // Burst value of the ith balloon
                    }
                    if(k != j){
                        after = dp[k+1][j];                                                             // Burst value of the jth balloon
                    }
                dp[i][j] = Math.max(dp[i][j], before + left * nums[k] * right + after);                                     // Total burst value
                k++;                                                                                    // Next element in subarray same procedure
            }
        }
    }
        return dp[0][nums.length-1];                                                                    // Return the max burst value
    }
}