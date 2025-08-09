class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [[0 for i in range(n)] for j in range(n)]

        for chainLen in range(1, n + 1):
            for i in range(n - chainLen + 1):
                j = i + chainLen - 1
                res = float("-inf")
                for k in range(i, j + 1):
                    left, right = 1, 1
                    if i - 1 >= 0:
                        left = nums[i - 1]
                    if j + 1 < n:
                        right = nums[j + 1]
                    currBurstVal = nums[k] * left * right 
                    leftSub, rightSub = 0, 0
                    if k - 1 >= 0:
                        leftSub = dp[i][k - 1]
                    if k + 1 < n:
                        rightSub = dp[k + 1][j]
                    res = max(currBurstVal + leftSub + rightSub, res)
                dp[i][j] = res
        return dp[0][n - 1]
