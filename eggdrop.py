# Time complexity - O(K*N^2)
# Space complexity - O(NK)
# Did this solution run on leetcode? - No (TLE)
class Solution:
    def superEggDrop(self, K: int, N: int) -> int:
        # dp array
        # (K+1) X (N+1)
        dp = [[0 for _ in range(N+1)] for _ in range(K+1)]
        
        for i in range(1, N+1):
            dp[1][i] = i
        
        for i in range(2, K+1):                         # O(K)
            for j in range(1, N+1):                     # O(N)
                dp[i][j] = float('inf')
                # check for every floor before the current floor.
                for step in range(j):                   # O(N)
                    dp[i][j] = min(dp[i][j], 1+max(dp[i-1][step], dp[i][j-step-1]))
        
        # print(dp)
        return dp[-1][-1]
        

# By calculating the number of floors that can be covered by given number of eggs and attempts.
# prev[i-1] - if the egg breaks.
# prev[i] - if the egg doesn't break.
# Time complexity - O(K*N)
# Space complexity - O(N)
class Solution:
    def superEggDrop(self, K: int, N: int) -> int:
        # don't need a dp array, we just need the value of previous row (no of eggs)
        prev = [0 for _ in range(K+1)]
        
        for j in range(1, N+1):
            curr = [0]
            for i in range(1, K+1):
                val = 1 + prev[i-1] + prev[i] # cases - broken and not broken eggs
                if val >= N:
                    return  j
                curr.append(val)
            prev = curr
        
        return N
        