# Time: O(nk^2)
# Space: O(n^2) 
# Did it run on Leetcode: yes

class Solution(object):
    def superEggDrop(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: int
        """
        # O(nk^2), O(n^2)
        
        # # print(dp)
        # # return 0
        # for j in range(1, n+1):
        #     dp[1][j]=j
        # for i in range(1,k):
        #     dp[i][1]=1
        # for i in range(2, k+1):
        #     for j in range(2, n+1):
        #         minel=float('inf')
        #         for f in range(1, j+1):
        #             # curr num of moves
        #             curr=1 + max(dp[i-1][f-1], dp[i][j-f])
        #             minel=min(minel, curr)
        #         dp[i][j]=minel
        # return dp[k][n]

        # O(nk), O(n^2)
        attempts=0
        dp=[[0 for _ in range(k+1)]for _ in range(n+1)]
        while(dp[attempts][k]<n):
            attempts+=1
            for j in range(1,k+1):
                dp[attempts][j]=1+ dp[attempts-1][j-1] + dp[attempts-1][j]

        return attempts