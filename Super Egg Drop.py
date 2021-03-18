class Solution:
    #Solution 1
    def superEggDrop(self, k: int, n: int) -> int:
        #Approach: Dynamic Programming
        #Time Complexity: O(k * n)
        #Space Complexity: O(k * n)
        
        #rows : moves  ;  columns : eggs  ;  cells : max floors
        dp = [[0 for j in range(k + 1)] for i in range(n + 1)]
        
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                dp[i][j] = 1 + dp[i - 1][j - 1] + dp[i - 1][j]
                if dp[i][j] >= n:
                    return i
    
    #Solution 2
    """
    def superEggDrop(self, k: int, n: int) -> int:
        #Approach: Dynamic Programming
        #Time Complexity: O(k * n^2)
        #Space Complexity: O(k * n)
        
        #rows : eggs  ;  columns : floors  ;  cells : min moves
        dp = [[0 for j in range(n + 1)] for i in range(k + 1)]
        
        #Second row
        for j in range(1, len(dp[0])):
            dp[1][j] = j
        
        for i in range(2, len(dp)):
            for j in range(1, len(dp[0])):
                dp[i][j] = inf
                for f in range(1, j + 1):
                    dp[i][j] = min(dp[i][j], 1 + max(dp[i - 1][f - 1], dp[i][j - f]))
                    
        return dp[-1][-1]
    """