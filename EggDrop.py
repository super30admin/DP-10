------------------------Egg Drop Problem------------------------------------------
# Time Complexity : O(N**2XK) as N is the number of floors and K is the number of eggs 
# Space Complexity : O(NXK)  No extra space
# Did this code successfully run on Leetcode : Time Limit Exceeded
# Any problem you faced while coding this : No
# 
# We will create a dp array and iterate through each and every floor untill my j th floor and check the max of breaking and not breaking
# and find the minimum number of attempts taken by starting from which floor. In this way I will iterate through all combinations
# of floors with breaking and non breaking conditions and find minimum


class Solution:
    def superEggDrop(self, K: int, N: int) -> int:
        dp = [[0 for i in range(N+1)] for j in range(K+1)]
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if i == 1:
                    dp[i][j] = j
                else:
                    dp[i][j] = float('inf')
                    for k in range(1, j+1):
                        temp= 1+max(dp[i-1][k-1], dp[i][j-k])
                        dp[i][j] = min(dp[i][j], temp)
        return dp[-1][-1]


-------------------------Egg Drop Problem------------------------------------------
# Time Complexity : O(NXK) as N is the number of floors and K is the  number of eggs.
# Space Complexity : O(NXK)  No extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I created a dp array with columns as my eggs and rows as my number of attempts. I will iterate through the 
# dp array and find out the floors I can check with the number of attempts and eggs I have by adding up the values of breaking 
# and non breaking values.

class Solution:
    def superEggDrop(self, K: int, N: int) -> int:        
		dp = [[0 for i in range(K+1)] for j in range(N+1)]
        res = N
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if j == 1:
                    dp[i][j] = i
                else:
                    dp[i][j] = 1+dp[i-1][j-1]+dp[i-1][j]
                
                if dp[i][j] >=N:
                    return i
        return res