// Time Complexity - DP: O(n^2*k) ; Optimised DP: O(nk)
// Space Complexity - O(nk)
// Approach
// We start from first floor and one egg check the no of attempts we take. Gradually, we increase
// it till N and K. But for each of the floor, we need to check what happens if the egg breaks and what if the egg 
// doesnt break. We check it for each of the floor and for each floor we further check the situation from 1 to floor number.abstract
// In optimal DP, we use attempts to calculate the no of floors required. We return the no of attempts once it becomes greater
// than N because we have reached a point where N floors have been explored.


// Using DP

class Solution {
    public int superEggDrop(int K, int N) {
        if(N == 0 || K == 0) return 0;
        int[][] dp = new int[K+1][N+1];
        for(int i=1;i<dp[0].length;i++) {
            dp[1][i] = i;
        }
        for(int k=2;k<dp.length;k++) {
            for(int n=1;n<dp[0].length;n++) {
                int min = Integer.MAX_VALUE;
                dp[k][n]= Integer.MAX_VALUE;
                for(int f=1;f<=n;f++) {
                    min = 1+Math.max(dp[k-1][f-1],dp[k][n-f]);
                    dp[k][n] = Math.min(min,dp[k][n]);
                }
            }
        }
        return dp[K][N];
    }
}

// Optimised DP
class Solution {
    public int superEggDrop(int K, int N) {
        if(N == 0 || K == 0) return 0;
        int[][] dp = new int[N+1][K+1];
        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {
                dp[i][j] = 1+dp[i-1][j-1]+dp[i-1][j];
                if(dp[i][j]>=N) return i;
            }
        }
        return 0;
    }
}