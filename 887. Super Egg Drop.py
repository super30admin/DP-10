'''
T = O(kn^2)
S = O(kn)

Approach:
Check all the possible best worst ways of dropping the eggs
'''


class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[0 for _ in range(n+1)]for _ in range(k+1)]
        
        for i in range(1, n+1):
            dp[1][i] = i

        for i in range(2, k+1):                         # O(K)
            for j in range(1, n+1):                     # O(N)
                dp[i][j] = float('inf')
                for step in range(j):                   # O(N)
                    dp[i][j] = min(dp[i][j], 1+max(dp[i-1][step], dp[i][j-step-1]))
        return dp[-1][-1]
		

'''
T = O(kn)
S = O(kn)

Approach:
Check all the possible ways of dropping the eggs at each floor.
'''
class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        prev = [0 for _ in range(k+1)]

        for j in range(1, n+1):
            curr = [0]
            for i in range(1, k+1):
                val = 1 + prev[i-1] + prev[i] # cases - broken and not broken eggs
                if val >= n:
                    return  j
                curr.append(val)
            prev = curr

        return n