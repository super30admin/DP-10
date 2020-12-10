class Solution {//Time and space of O(K*N)
    public int superEggDrop(int K, int N) {
        
        int[][] dp = new int[N+1][K+1];
        int attempts = 0;
        
        while(dp[attempts][K]<N){
            attempts++;
            for(int eggs=1 ; eggs<=K ; eggs++){
                dp[attempts][eggs] = 1 + dp[attempts-1][eggs-1] + dp[attempts-1][eggs];
            }
        }
        return attempts;
    }
}