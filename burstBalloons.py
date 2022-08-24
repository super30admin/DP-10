# TC: O(n^3)
# SC: O(n^2)
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0
        n = len(nums)
        dp = [[0 for _ in range(n)] for _ in range(n)]
        
        for l in range(1, n+1):
            for i in range(n-l+1):
                j = i+l-1
                maxN = float("-inf")
                for k in range(i, j+1):
                    left, right = 1, 1
                    if i != 0:
                        left = nums[i-1]
                    if j != n-1:
                        right = nums[j+1]
                    before, after = 0, 0
                    if k != j:
                         after = dp[k+1][j]
                    if k != i:
                        before = dp[i][k-1]
                    maxN = max(maxN, before+left*nums[k]*right+after)
                dp[i][j] = maxN
        return dp[0][n-1]