'''
Accepted on leetcode(312)
time - O(N^3)
space - O(N^2)
'''


class Solution:
    def maxCoins(self, nums) -> int:
        N = len(nums)

        # edge case
        if len(nums) == 0:
            return 0

        dp = [[0 for i in range(N)] for i in range(N)]

        for length in range(1, N + 1):
            for i in range(N - length + 1):
                j = i + length - 1
                for k in range(i, j + 1):

                    # before + (leftValue * element * rightValue) + after
                    # left and right values are calculated from outside the considered sequence.

                    leftValue = 1
                    rightValue = 1

                    if i != 0:
                        leftValue = nums[i - 1]
                    if j != N - 1:
                        rightValue = nums[j + 1]

                    # before and after are calculated from the values within the considered sequence.
                    before = 0
                    after = 0

                    if i != k:
                        before = dp[i][k - 1]

                    if j != k:
                        after = dp[k + 1][j]

                    dp[i][j] = max(dp[i][j], before + (leftValue * nums[k] * rightValue) + after)

        print(dp)

        return dp[0][N - 1]