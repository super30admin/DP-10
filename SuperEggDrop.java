class SuperEggDrop {
    
    // Time Complexity: O(nk)
    // Space Complexity: O(nk)
    
    public int superEggDrop(int k, int n) {
        if(k == 1 || n <= 1)
            return n;
        
        // no. of attempts -> rows
        // no. of eggs -> cols
        int[][] dp = new int[n+1][k+1];
        int attempts = 0;
        
        while(dp[attempts][k] < n){
            attempts += 1;
            for(int j = 1; j <= k; j++){
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j];
            }
        }
        return attempts;
    }
}