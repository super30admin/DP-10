# Time O(n^3)
# Space O(n^2)

# Approach is bottom up dp
#  Runs on leetcode

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if not nums: return 0
        dp = [[0 for j in range(len(nums))] for i in range(len(nums))]

        for i in range(len(nums)):
            left = nums[i - 1] if i - 1 >= 0 else 1
            right = nums[i + 1] if i + 1 <= len(nums) - 1 else 1

            dp[i][i] = left * nums[i] * right

        for length in range(2, len(nums) + 1):
            for i in range(len(nums) - length + 1):

                j = i + length - 1
                for k in range(i, j + 1):
                    left_profit = dp[i][k - 1] if k > 0 else 0
                    right_profit = dp[k + 1][j] if k < len(nums) - 1 else 0

                    left_ele = nums[i - 1] if i - 1 >= 0 else 1
                    right_ele = nums[j + 1] if j + 1 <= len(nums) - 1 else 1

                    curr_profit = left_ele * nums[k] * right_ele
                    total_curr = left_profit + curr_profit + right_profit

                    dp[i][j] = max(dp[i][j], total_curr)

        return dp[0][len(nums) - 1]


