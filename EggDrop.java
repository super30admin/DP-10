class Solution {
    public int superEggDrop(int K, int N) {
        
        int[][] dp = new int[n+1][k+1];
        
        int attempts = 0;
        
        while(dp[attempts][k] < n){
            attempts += 1;
            
            for(int j = 1; j <= k; j++){
                dp[attempts][k] = 1+ dp[attempts - 1][j - 1] + dp[attempts - 1][j];
            }
        }
        
        return attempts;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)