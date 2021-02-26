// Time - O(NK), Space - O(NK)

class Solution {
    public int superEggDrop(int K, int N) {
        
        
        int[][] dp = new int[N+1][K+1];
        int i = 0;
        while(dp[i][K] < N) {
            i++;
            if(dp[i][K] > N) {
                return i;
            }
            for(int j=1;j<=K;j++) {
                dp[i][j] = 1 + dp[i-1][j-1] + dp[i-1][j];
            }
        }
        
        return i;
    }
}
