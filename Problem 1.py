# Time: O(n*k*n)
# Space: O(n*k)
class Solution(object):
    def superEggDrop(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: int
        """
        dp = [[0 for i in range(n+1)] for j in range(k+1)]
         
        for j in range(n+1):
            dp[1][j] = j
        for i in range(2, k+1):
            for j in range(1, n+1):
                mn = 10000000000000007
                for p in range(1, j+1):
                    braken = dp[i-1][p-1]
                    not_braken = dp[i][j-p]
                    mx = 1+max(braken, not_braken)
                    mn = min(mn, mx)
                dp[i][j] = mn
        return dp[k][n]
                    
                    

# Time: O(n*k)
# Space: O(n*k)
class Solution(object):
    def superEggDrop(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: int
        """
        dp = [[0 for i in range(k+1)] for j in range(n+1)]
        for i in range(1, n+1):
            for j in range(1, k+1):
                dp[i][j] = 1+dp[i-1][j-1]+dp[i-1][j]
                if dp[i][j] >= n:
                    return i
        
            
                    
