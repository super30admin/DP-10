# Time Complexity: O(k * n^2)
# Space Complexity: O(k * n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def superEggDrop(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: int
        """
        m = 300
        dp = [[0 for j in range(k + 1)] for i in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, k + 1):
                dp[i][j] = (1 + dp[i - 1][j] + dp[i - 1][j - 1])
                if (dp[i][j] >= n):
                    return i