// Time Complexity : O(K*N) where K is the number of eggs and N is the number of floors
// Space Complexity : O(K*N) where K is the number of eggs and N is the number of floors
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class superEggDrop {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N+1][K+1]; // max rows can be N i.e. number of floors
        int attempts = 0; 
        while (dp[attempts][K] < N) { // while floors required are less than floors available
            attempts++;
            for (int j = 1; j <= K; j++) {
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];
            }
        }
        return attempts;
    }
}