//TC - O(n^3)
//SC - O(n^2)
//https://leetcode.com/problems/burst-balloons/
class Solution {
  public int maxCoins(int[] nums) {
      if (nums == null || nums.length == 0)
          return 0;
      int n = nums.length;
      int[][] dp = new int[n][n];
      for (int len = 1; len <= n; len++) { // sub problem length
          for (int start = 0; start <= n - len; start++) { // start idx of burstible array
              int end = start + len - 1; // end idx of burstible array
              for (int k = start; k <= end; k++) { // k runs from start to end
                  // curr = before + left*k*right + after
                  int left = start > 0 ? nums[start - 1] : 1;
                  int right = end < n-1 ? nums[end + 1] : 1;
                  int before = start == k ? 0 : dp[start][k - 1];
                  int after = end == k ? 0 : dp[k + 1][end];
                  int curr = before + left * nums[k] * right + after;
                  dp[start][end] = Math.max(dp[start][end], curr);
              }
          }
      }
      return dp[0][n - 1];
  }
}
public class BurstBalloons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
