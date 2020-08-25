
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# Brute Force 
# TC = O(n^2 x K) | Space = O(NK)
# Approach is to try and test out all the possibilites of the maximum attempts needed to know at which floor 
# did the egg was unbroken. To find out that, for each floor we need to consider the attempt for that floor 
# go up to the last floor. That is why this is a N^2 extra in the solution. 
class Solution:
    def superEggDrop(self, K, N):
        dp = [[0 for _ in range(N+1)] for _ in range(K+1)]
        
        for j in range(1,len(dp[0])):
            dp[1][j] = j

        for i in range(2, len(dp)):
            for j in range(1, len(dp[0])):
                dp[i][j] = float('inf')
                
                for l in range(1, j+1): # for all the floors get the max attempts
                    dp[i][j] = min(dp[i][j], 1 + max(dp[i-1][l-1], dp[i][j-l]))
        print(dp)    
        return dp[-1][-1]

# Optimal solution 
# Tc = O(NK log N) | Sc = O(NK)
# Approach is that this time, for each attempt, we use that attempt to figure out the total possibility of 
# egg broken + not borken + 1 is < N(total floors). We dont need to calculate further. as soon as 
# dp[attempt][K] hits a mark of equal to or greater than N, we return the attempt counter. 
# class Solution:
#     def superEggDrop(self, K: int, N: int) -> int:
#         dp = [[0 for _ in range(K+1)] for _ in range(N+1)]
        
#         attempt = 0 
#         while dp[attempt][K] < N:
#             attempt += 1 
#             for i in range(1, K+1):
#                 dp[attempt][i] = 1 + dp[attempt-1][i-1] + dp[attempt-1][i]
#                 if dp[attempt][i] >= N :
#                     return attempt
        
#         return attempt
        
if __name__ == "__main__":
    s = Solution()
    
    # Test case 1 
    assert 2 == s.superEggDrop(1, 2)
    assert 3 == s.superEggDrop(3, 4)
    