# Time Complexity : O(n*k)
# Space Complexity : O(k)
# Code ran on LeetCode
# For a given combination of eggs and attempts, calculate the maximum number of floors that can be explored.
class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [0]*(k+1)
        attempts = 0
        while dp[k] < n:
            attempts += 1
            diagUp = 0
            for j in range(1, k + 1):
                temp = dp[j]
                dp[j] = 1 + dp[j] + diagUp
                diagUp = temp
        return attempts
            