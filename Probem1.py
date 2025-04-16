# Problem 1 : Super Egg Drop
# Time Complexity : O(n*k) where n is the number of the floors and k is the number of eggs
# Space Complexity : O(n*k) where n is the number of the floors and k is the number of eggs
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        # define dp matrix with size (n+1)(k+1) and fill with 0
        dp = [[0 for _ in range(k+1)] for _ in range(n+1)]
        # define attempts variable and set to 0
        attempts = 0
        # loop till the value of dp at attempt and k posiion is less than nth floor
        while(dp[attempts][k] < n):
            # increment attempt
            attempts += 1
            # loop from 1 to (k+1)(ie from 1 to k+1 eggs)
            for j in range(1, k+1, 1):
                # value of dp matrix at attempts and j position is sum of 1, value of dp matrix at (attempts-1)(j-1)th position (ie. break)
                # and at (attempt-1)(j)th position (ie non-breakable)
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j]
        # return the value of attempts
        return attempts
