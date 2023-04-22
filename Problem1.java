/*
Burst Balloon
approach: dp with permutations
time: O(n^3)
space: O(n^2)
 */
public class Problem1 {
    public int maxCoins(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i=1;i<=n;i++) {

            for (int j = 0;j<=n-i;j++) {
                int l = j+i-1;
                for (int k = j;k<=l;k++) {
                    int left = 1;
                    int right = 1;
                    if (j!=0) left = nums[j-1];
                    if (l!=n-1) right = nums[l+1];
                    int before = (k!=j)?dp[j][k-1]:0;
                    int after = (k!=l)?dp[k+1][l]:0;
                    int coins = before+left*nums[k]*right+after;
                    dp[j][l] = Math.max(dp[j][l], coins);
                }
            }
        }
        return dp[0][n-1];
    }
    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        problem1.maxCoins(new int[]{4,1,2,5});
    }
}
