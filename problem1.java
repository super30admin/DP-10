class superEggDrop1 {
    public int superEggDrop(int k, int n) {
        if(n == 0 || k == 0) return 0;
        
        int[][] dp = new int[n + 1][k + 1];
        int attempts = 0;
        
        while(dp[attempts][k] < n){
            attempts++;
            for(int i = 1; i <= k; i++){
                dp[attempts][i] = 1 + dp[attempts - 1][i - 1] + dp[attempts - 1][i];
            }
        }
        return attempts;
    }
}

//time complexity O(n * k)
//space complexity O(n * k) where n and k is given value