"""
Time Complexity : O(NK) - where N is the number number of attempts(worst case equal to number of floors) and K is number of eggs
Space Complexity : O(2K)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
The basic approach here would be to perform DP and calculate how many attempts do we need for 1-K number of eggs for each floor. 
To start with, lets say we have 2 eggs and 4 floors. Then we would calculate, how many attempts if I had 1 egg for 1 floor, 
2 floors, 3 floors and 4 floors.Same goes for 2 eggs. Also, for 1 egg and 2 floors, we would look for all permutations. We can
also drop from the first floor first and start going up or drop from last floor first and start coming down. We need to calculate
both ways and take its minimum. Also, while calculating this, lets say 1 egg and 2 floors , and we started from first floor,
then we used 1 attempt. Now there are 2 possinilities, either the egg would break or not. If it breaks, we are left with 1 less egg
and we need to keep an eye on floors which are below it. If it does not break, we have same number of eggs, and now we need to see
the floors above. This solution gives Time Limit exceeded even for DP and has T(O(K N^2)).

A better approach would be to calculate number of floors for a given number of attempts starting from 1. Lets say we have 2 eggs
and  1 attempt. So number of floors covered would be (1 (when I used that attempt) + floors for 0 attempt (1 less) and 1 egg(1 less)
if it broke + floors for 0 attempt (1 less) and 2 eggs(if did not break). Calculate this till the number of floors become more
than the floors given. The used attempts would be the ans. this would be T(O(NK)) approach and use a 2D array.

A more better approach would be to use 2 single D arrays as prev and curr as we do not need the whole matrix to calculate values.
"""


class Solution:
    def superEggDrop(self, K: int, N: int) -> int:
        prev = [0] * (K+1)
        curr = [0] * (K+1)
        attempts = 0
        while prev[K] < N:
            attempts += 1
            for i in range(1, K+1):
                curr[i] = 1+prev[i-1]+prev[i]
            curr, prev = prev, curr
        return attempts


# class Solution:
#     def superEggDrop(self, K: int, N: int) -> int:
#         dp=[[0 for i in range(K+1)] for j in range(N+1)]
#         attempts=0
#         while dp[attempts][K]<N:
#             attempts+=1
#             for i in range(1,K+1):
#                 dp[attempts][i]=1+dp[attempts-1][i-1]+dp[attempts-1][i]
#         return attempts


# class Solution:
#     def superEggDrop(self, K: int, N: int) -> int:
#         dp=[[0 for i in range(N+1)] for j in range(K+1)]
#         for i in range(1,N+1):
#             dp[1][i]=i
#         for i in range(2,K+1):
#             for j in range(1,N+1):
#                 dp[i][j]=float('inf')
#                 for k in range(1,j+1):
#                     dp[i][j]=min(dp[i][j],1+max(dp[i-1][k-1],dp[i][j-k]))
#         return dp[-1][-1]
