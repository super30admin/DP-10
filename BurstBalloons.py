# Time complexity: O(n^3) as we have 3 nested loops
# Space is O(n^2)

# The intuition here to use a DP approach. We technically burst one balloon, then 2 balloon, then 3 balloon and so on at a time. Because we are
# to do a permutation. Here the order matters as to which balloon will burst first.
# Then we calculate the left burstable balloons, right burstable balloons using already calculated dp array for smallers sizes
# and the value of the current balloon and get the max out of it.

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [[0] * n for _ in range(n)]

        for le in range(1, n + 1):
            # Starting idx of the burstable index
            for i in range(0, n - le + 1):
                j = i + le - 1  # end index of the burstable
                maxVal = float("-inf")
                for k in range(i, j + 1):
                    # left, middle ln * nums[k] * rn, right
                    left = 0
                    if (i != k):
                        left = dp[i][k - 1]
                    right = 0
                    if j != k:
                        right = dp[k + 1][j]
                    ln = 1
                    if (i > 0):
                        ln = nums[i - 1]
                    rn = 1
                    if (j < n - 1):
                        rn = nums[j + 1]
                    curr = left + (ln * nums[k] * rn) + right
                    maxVal = max(curr, maxVal)
                dp[i][j] = maxVal
        return dp[0][n - 1]