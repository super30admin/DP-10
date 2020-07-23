#Time Complexity : O(N*M) where N is Number of rows and M is number of Columns
#Space Complexity : O(N*M) 
class Solution(object):
    def superEggDrop(self, K, N):
        """
        :type K: int
        :type N: int
        :rtype: int
        """
        dp = [[0 for eggs in range(K + 1)] for attempts in range(N + 1)]

        for attempt in range(1, N + 1):
            for eggs in range(1, K + 1):
                dp[attempt][eggs] = 1 + dp[attempt - 1][eggs] + dp[attempt - 1][eggs - 1]
                if dp[attempt][eggs] >= N:
                    return attempt

        return dp[K][N]
==========================================================================================
#Time Complexity : O(N*M) where N is Number of rows and M is number of Columns
#Space Complexity : O(N*M) 
class Solution(object):
    def superEggDrop(self, K, N):
        """
        :type K: int
        :type N: int
        :rtype: int
        """
        dp = [[0 for floors in range(N + 1)] for eggs in range(K + 1)]
        
        for j in range(1,len(dp[0])):
            dp[1][j] = j

        for i in range(2, len(dp)):
            for j in range(1, len(dp[0])):
                dp[i][j] = float('inf')
                for f in range(1,j+1):
                    dp[i][j] = min( dp[i][j], 1 + max(dp[i - 1][f-1] , dp[i][j-f ]))

        return dp[K][N]