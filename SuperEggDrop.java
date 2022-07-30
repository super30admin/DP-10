// Time Complexity : O(kn)
// Space Complexity : O(kn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class SuperEggDrop {
    class Solution {
        public int superEggDrop(int k, int n) {
            int maxAttempts = n;
            int[][] dp = new int[maxAttempts+1][k+1];
            int attempts = 0;
            boolean flag = true;
            while(flag && dp[attempts][k] < n) {
                attempts++;
                for(int j=1; j<dp[0].length; j++) {
                    dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];
                    if(attempts >= n){
                        flag = false;
                        break;
                    }
                }
            }
            return attempts;
        }
    }
}
