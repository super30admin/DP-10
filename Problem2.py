# Problem 2: Burst Balloons
from typing import List
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [[0 for _ in range(n)]for _ in range(n)]

        for le in range(1,n+1):
            for i in range(0,n-le+1):
                j = i + le - 1
                for k in range(i,j+1):
                    before, after = 0,0
                    if i < k:
                        before = dp[i][k-1]
                    if j > k:
                        after = dp[k+1][j]
                    Prev,Next = 1,1
                    if i != 0: Prev = nums[i-1]
                    if j != n-1: Next = nums[j+1]
                    balloonItself = Prev * nums[k] * Next
                    dp[i][j] = max(dp[i][j],before+balloonItself+after)

        return dp[0][n-1]