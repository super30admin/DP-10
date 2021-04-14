# Time Complexity : O(NK)
# Space Complexity : O(NK)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using DP Approach


class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[0 for j in range(k + 1)] for i in range(n + 1)]
        attempts = 0
        while dp[attempts][k] < n:
            attempts += 1
            for j in range(1, len(dp[0])):
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts -
                                                                   1][j]
        return attempts
