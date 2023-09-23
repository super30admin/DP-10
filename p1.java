// Time Complexity :O(n*k)
// Space Complexity :O(n*k)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n+1][k+1];
        //Set the first row as 1 starting from index 1. I number of tries is 1, we can only explore 1 floor
        for(int i=1; i<= k; i++){
            dp[1][i] = 1;
        }
        if(n == 1 || n==0) return dp[n][k];
        //Set the first column as number of tries. Since if the egg is 1, we would need all the tries to explore all the floors
        for(int i=2; i<= n; i++){
            dp[i][1] = i;
        }
        //number of floors is equal to 1 + egg breaks + egg does not break
        for(int i=2; i<=n; i++){
            for(int j=1; j<=k; j++){
                dp[i][j] = 1 + dp[i-1][j-1] + dp[i-1][j];
                if(n <= dp[i][j]) return i;
            }
        }
        return -1;
    }
}