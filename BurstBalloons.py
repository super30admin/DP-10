'''
TC :O(n^3) - to iterate over the nums for 2d matrix and going through
            the n elements in each burstible array
SC :O(n^2) - to store the dp
'''
from typing import List

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        ROWS, COLS = len(nums), len(nums)
        dp = [[-float('inf')  for _ in range(COLS)] for _ in range(ROWS)]

        for level in range(1, ROWS+1):
            for i in range(0, COLS-level+1):
                j = i+level-1
                for index in range(i,j+1):
                    element = nums[index]
                    before = 0
                    if index != i:
                        before = dp[i][index-1]
                    after = 0
                    if index != j:
                        after = dp[index+1][j]
                    left = 1
                    if i-1>=0:
                        left = nums[i-1]
                    right = 1
                    if j+1<COLS:
                        right = nums[j+1]
                    curr = before + (left*nums[index]*right) + after
                    dp[i][j] = max(dp[i][j], curr)
        return dp[0][COLS-1]
s = Solution()
print(s.maxCoins([3,1,5,8]))
print(s.maxCoins([1,5]))