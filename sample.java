// Time Complexity : O(nlogk)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int superEggDrop(int k, int n) {
        int dp[] = new int[k + 1], m = 0;
        for (m = 0; dp[k] < n; ++m)
            for (int i = k; i > 0; i--)
                dp[i] += dp[i - 1] + 1;
        return m;
    }
    }