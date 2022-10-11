//O(NxK) time and space complexity

class Solution {
    public int superEggDrop(int k, int n) {
        int attempts = 0;
        int[][] dp = new int[n+1][k+1];
        while(dp[attempts][k]<n){
            attempts++;
            for(int i=1;i<=k;i++){
                dp[attempts][i] = 1 + dp[attempts-1][i] + dp[attempts-1][i-1];
            }
        }
        return attempts;
    }
}
