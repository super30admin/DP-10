// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: Checked for attempts instead of floors. If attempts go greater than floor then return attempts

class Solution {
    public int superEggDrop(int K, int N) {

        int[][] flr = new int[N + 1][K + 1];

        for (int att = 1; att <= N; att++) {
            for (int k = 1; k <= K; k++) {
                flr[att][k] = 1 + flr[att - 1][k - 1] + flr[att - 1][k];
                if (flr[att][k] >= N) {
                    return att;
                }
            }
        }

        return N;
    }
}