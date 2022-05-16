// Time Complexity : O(N ^ 3) where n is the length of the array
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// To handle corner balloons case add 1 to each side
// Now we will write dp function where we will burst all the ballons
// from beging to the left of current and all after right of the current
// Now we will burst the current
// we can store the sum of these and compare with current max and store
// Finally we will store it to the memoization array. We will return the result after all 
// computations.
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] newNums = new int[n];
        System.arraycopy(nums, 0, newNums, 1, n-2);
        newNums[0] = 1;
        newNums[n - 1] = 1;
        int[][] memo = new int[n][n];
        return dp(memo, newNums, 1, n-2);
    }
    public int dp(int[][] memo, int[] nums, int left, int right) {
        if(right - left < 0)
            return 0;
        if(memo[left][right] > 0){
            return memo[left][right];
        }
        int result = 0;
        for(int i = left; i <= right; i++){
            int gain = nums[left - 1] * nums[i] * nums[right + 1];
            int remaining = dp(memo, nums, left, i-1) + dp(memo, nums, i + 1, right);
            result = Math.max(result, remaining + gain);
        }
        memo[left][right] = result;
        return result;
    }
}