# Time Complexity : O(n^3)
# Space Complexity : O(n^2)
class Solution:
    def maxCoins(self, nums: list[int]) -> int:
        n = len(nums)
        new_nums = [1] * (n + 2)
        for i in range(n):
            new_nums[i + 1] = nums[i]

        dp = [[0] * (n + 2) for _ in range(n + 2)]

        for length in range(1, n + 1):
            for left in range(1, n - length + 2):
                right = left + length - 1
                for k in range(left, right + 1):
                    dp[left][right] = max(dp[left][right],
                        new_nums[left - 1] * new_nums[k] * new_nums[right + 1] + dp[left][k - 1] + dp[k + 1][right])

        return dp[1][n]

# Examples
solution = Solution()

# Example 1
nums1 = [3, 1, 5, 8]
result1 = solution.maxCoins(nums1)
print("Example 1: nums = {} -> Maximum coins = {}".format(nums1, result1)) # Example 1: nums = [3, 1, 5, 8] -> Maximum coins = 167

# Example 2
nums2 = [1, 5]
result2 = solution.maxCoins(nums2)
print("Example 2: nums = {} -> Maximum coins = {}".format(nums2, result2)) # Example 2: nums = [1, 5] -> Maximum coins = 10

# Example 3
nums3 = [7, 9, 8, 0, 7]
result3 = solution.maxCoins(nums3)
print("Example 3: nums = {} -> Maximum coins = {}".format(nums3, result3)) # Example 3: nums = [7, 9, 8, 0, 7] -> Maximum coins = 1818