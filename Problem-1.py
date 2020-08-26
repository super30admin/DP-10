# Time Complexity :O(N * K^2)
# Space Complexity :O(N*K) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    def superEggDrop(self, K, N):
        """
        :type K: int
        :type N: int
        :rtype: int
        """
        # create DP array of n+1 and k+1
        dp = [[0]*(K+1) for i in range(N+1)]
        # for each number of attempts
        for attempts in range(1,len(dp)):
            # for each number of eggs
            for eggs in range(1,len(dp[0])):
                # dp of attemps and eggs = 1+ using your attemps and breaking the egg + using your attemps wothout breaking the egg
                dp[attempts][eggs] = 1+ dp[attempts-1][eggs] + dp[attempts-1][eggs-1]
                # if you can cover all floors return attemps
                if dp[attempts][eggs] >= N:
                    return attempts