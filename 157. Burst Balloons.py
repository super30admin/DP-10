class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0

        n = len(nums)
        dp = [[0] * n for i in range(n)]

        for l in range(1, n + 1):
            # starting point of burstable balloons array
            for i in range((n - l) + 1):
                # last index of burstable balloons array
                j = i + (l - 1)
                for k in range(i, j + 1):
                    before = 0
                    after = 0

                    if i != k:
                        # before is value of balloon burst before those sub problem
                        # is already calculated
                        # e.g [2,3,4] if we are bursting 3 then before will be value of 2
                        before = dp[i][k - 1]

                    if j != k:
                        # after is value of balloon burst after those sub problem
                        # is already calculated
                        # e.g [2,3,4] if we are bursting 3 then after will be value of 4
                        after = dp[k + 1][j]

                    left = 1
                    right = 1

                    if i != 0:
                        left = nums[i - 1]

                    if j != n - 1:
                        right = nums[j + 1]

                    dp[i][j] = max(dp[i][j], before + (left * nums[k] * right) + after)

        return dp[0][-1]

# Dynamic Programming
# Time Complexity: O(n^3)
# Space Complexity: O(n^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
