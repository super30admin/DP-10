#Time Complexity : O(n^3) where n is the length of the input
#Space Complexity : O(n^2) 
#Did this code successfully run on Leetcode : Yes

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if not nums:
            return 0
        n = len(nums)
        dp = [[0 for _ in range(n)] for _ in range(n)]

        for length in range(1, n+1):
            for start in range(n-length+1):
                end = start + length - 1
                for i in range(start, end+1):
                    l, r = 1, 1
                    before, after = 0, 0
                    if start != 0:
                        l = nums[start-1]

                    if end != n-1:
                        r = nums[end+1]

                    if start != i:
                        before = dp[start][i-1]

                    if end != i:
                        after = dp[i+1][end]

                    dp[start][end] = max(dp[start][end], before + l*nums[i]*r + after)

        return dp[0][n-1]
