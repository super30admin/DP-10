# Time complexity: O(nk)
# Space complexity: O(nk)
# Approach: Use dynamic programming
# create a dp matrix of size n+1, k+1 representing attempts and eggs.
# concept is, at any place of the matrix, we will have 2 cases.
# case1- eggs breaks-> no.of.floors would be, dp[attempts-1][col-1], since we used one attempt and one egg broke
# case2-egg doesn't break->it will become, (dp[attempts-1][col]), one attempt used, no egg break so col remains same
# In addition, we would have used one floor since we used an attempt.
# total floors possible at a particular index would be, 1+dp[attempts-1][col-1]+dp[attempts-1][col]
# whenever the value of a particular index becomes greater than or equal to n(no.of.floors), return the attempts.





class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        if k ==0 or n== 0:
            return 0
        attempts = 1
        dp = [[0 for i in range(k+1)]for j in range(n+1)]
        while(attempts <= n):
            for col in range(1,k+1):
                dp[attempts][col] = 1+ dp[attempts-1][col-1] + dp[attempts-1][col]
                if dp[attempts][col] >= n:
                    return attempts
            attempts = attempts +1
        return attempts
        
            
        