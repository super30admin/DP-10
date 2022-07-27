# Time Complexity : O(N*K) where N is length of the nums array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[0 for _ in range(k+1)] for _ in range(n+1)]
        attempts  = 0
        flag = True
        while flag and dp[attempts][k] < n:
            attempts += 1
            for j in range(1, k+1):
                dp[attempts][j] = 1 + dp[attempts - 1][j-1] + dp[attempts - 1][j]
                if dp[attempts][j] >= n:
                    flag = False
                    break
        
        return attempts