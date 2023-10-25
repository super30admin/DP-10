// Time Complexity : O(nk) -->n floors or attempts k eggss
// Space Complexity :O(nk)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n+1][k+1];

        int attempts =0;
        while(dp[attempts][k]<n){ // since we are filling dp with floors the moment we are exceesing n floors we should stop
            attempts++; // increase the floors or attempts (rows)
            for(int j=1; j<=k;j++){    // looping through eggs (cols)
                // egg breaks and no egg breaks 
                dp[attempts][j] = 1+dp[attempts-1][j-1]+dp[attempts-1][j];  // fill with no.of floors instead of attempts
            }
        }
        return attempts; // we need min no.of attempts that require to find the floor from which the egg breaks
    }
}