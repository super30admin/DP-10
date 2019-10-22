class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        # Time Complexity : O(n^3) where n is the length of nums array
        # Space Complexity : O(n^2) because we have one dp array of that shape to store the values
        # Accepted on leetcode
        if nums == None or len(nums) == 0:
            return 0
        dp = [[0 for _ in range(len(nums))]for _ in range(len(nums))]
        n = len(nums)
        for l in range(1, n + 1):
            for i in range(0, n - l + 1):
                j = i + l - 1
                for k in range(i, j + 1):
                    left = 1
                    right = 1
                    if i != 0:
                        left = nums[i - 1]
                    if j != n - 1:
                        right = nums[j + 1]
                    before = 0
                    after = 0
                    if i != k:
                        before = dp[i][k - 1]
                    if j != k:
                        after = dp[k + 1][j]
                    dp[i][j] = max(before + left * nums[k] * right + after, dp[i][j])
        return dp[0][n - 1]