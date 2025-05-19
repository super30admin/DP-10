"""
DP with permutations approach -
TC = O(n^3)
SC = O(n^2)
"""
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0: return 0

        n = len(nums)
        dp = [[0 for i in range(n+1)]for i in range(n+1)]

        for _len in range(1, n+1):
            # i is the starting index of burstable array
            for i in range(0, n-_len+1):
                # ending index is given by j
                j = i + _len - 1
                for k in range(i, j+1):
                    left = 0
                    if k != i:
                        left = dp[i][k-1]
                    right = 0
                    if k != j:
                        right = dp[k+1][j]
                    before = 1
                    if i != 0:
                        before = nums[i-1]
                    after = 1
                    if j != n-1:
                        after = nums[j+1]
                    dp[i][j] = max(dp[i][j], left + before * nums[k] * after + right)
        return dp[0][n-1]