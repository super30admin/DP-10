# Time Complexity: O(n^2)
# Space Complexity: O(n)
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if (nums == None or len(nums) == 0):
            return 0
        nums = [1] + nums + [1]
        n = len(nums)
        dp = [[0 for i in range(n)] for j in range(n)]
        for length in range(2, n):
            for i in range(0, n - length):
                j = i + length
                for k in range(i+1, j):
                    before, after = dp[i][k], dp[k][j]
                    leftVal, rightVal = nums[i], nums[j]
                    curr = before + (leftVal * nums[k] * rightVal) + after
                    dp[i][j] = max(dp[i][j], curr)
        return dp[0][n - 1]