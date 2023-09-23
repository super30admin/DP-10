# Time Complexity: O(n^3)
# Space Complexity: O(n^2)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        A = ([1] + nums + [1])
        dp = [([0] * (n + 2)) for _ in range(n + 2)]
        for d in range(n):
            for i in range(1, (n - d + 1)):
                j = (i + d)
                for k in range(i, (j + 1)):
                    dp[i][j] = (max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + A[i - 1] * A[k] * A[j + 1]))
        return dp[1][n]