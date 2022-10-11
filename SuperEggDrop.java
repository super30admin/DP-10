// Time Complexity : O(n*k) where n = number of floors, k = number of eggs
// Space Complexity : O(n*k) where n = number of floors, k = number of eggs
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//887. Super Egg Drop (Hard) - https://leetcode.com/problems/super-egg-drop/
// Time Complexity : O(n*k) where n = number of floors, k = number of eggs
// Space Complexity : O(n*k) where n = number of floors, k = number of eggs
class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n+1][k+1];
        int attempts = 0;
        
        while (dp[attempts][k] < n) {
            attempts++;
            
            for (int j = 1 ; j <= k; j++) {
                dp[attempts][j] = 1 + dp[attempts-1][j] + dp[attempts-1][j-1];
            }
        }
        
        return attempts;
    }
}