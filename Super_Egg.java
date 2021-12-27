// Time Complexity :O(n)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int superEggDrop(int k, int n) {
        //k is no of eggs , n is no of floors 
        //dp rows correspond to Max no of attempts columns represent no of eggs
        //The value in dp is no of floors covered by corresponding attempts and eggs
        int[][] dp = new int[n+1][k+1];
        int attempts = 0;
        while(dp[attempts][k] < n){
            attempts += 1;
            for(int j = 1; j<=k; j++ ){
                dp[attempts][j] = 1 + dp[attempts-1][j-1] +dp[attempts-1][j];
            }
        }
        return attempts;
    }
}