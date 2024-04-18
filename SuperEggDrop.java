//https://leetcode.com/problems/super-egg-drop/
//TC - O(n^2 * k)
//SC - O(n * k)
class Solution31 {
  public int superEggDrop(int k, int n) {
      int[][] dp = new int[k + 1][n + 1];
      for (int i = 1; i <= n; i++) {
          dp[1][i] = i;
      }
      for (int i = 2; i <= k; i++) {
          for (int j = 1; j <= n; j++) {
              dp[i][j] = Integer.MAX_VALUE;
              for (int f = 1; f <= j; f++) {
                  dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i - 1][f - 1], dp[i][j - f])); //max of break and no-break scenario
              }
          }
      }
      return dp[k][n];
  }
}
public class SuperEggDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
