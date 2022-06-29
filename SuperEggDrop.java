// Time Complexity : O(nk)
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int superEggDrop(int k, int n) {
        if(n == 0 || k == 0) return 0;
        
        int[][] dp = new int[n + 1][k + 1];
        
        for(int i = 1; i <= k; i++) {
            dp[1][i] = i;
        }
        
        for(int attempts = 1; attempts <= n; attempts++) {
            for(int eggs = 1; eggs <= k; eggs++) {
                dp[attempts][eggs] = 1 + dp[attempts - 1][eggs - 1] + dp[attempts - 1][eggs];
                
                if(dp[attempts][eggs] >= n) return attempts;
            }
        }
        
        return -1;
    }
}