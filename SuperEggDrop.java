// Time Complexity : O(k* log n) - in this dp matrix, maximum value dp[attempts][k] < n is run will be until log n.
// Space Complexity : O(n*k
// Did this code successfully run on Leetcode : Yes
// Approach : We follow dp approach as it has repeated sub problems at each floor level. To achieve the best time complexity, this problem
// has to be first solved by considering number of attempts and eggs in the dp matrix and compute the maximum floors possible for each
// combination. This dp matrix values gives the range of values that number of floors can be found so we loop until dp matrix row values
// are less than n. Once this condition is not satisfied, the number of attempts is returned and it gives the result.

class Solution {
    public int superEggDrop(int k, int n) {
        int attempts = 0;
        int[][] dp = new int[n+1][k+1]; //dp matrix for attempts * eggs
        while(dp[attempts][k] < n){ //until n is found
            attempts++;
            for(int j = 1; j<=k;j++){
                dp[attempts][j] = 1 + dp[attempts-1][j-1]+ dp[attempts-1][j];
            }
        }
        return attempts;
    }
}