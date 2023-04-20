#All TC on leetcode passed

class Solution:
    def superEggDrop(self, k: int, n: int) -> int:

        #Here we use the prev DP approach but instead of iterating through all floors for a given cell, we change the dp matrix to attemps vs eggs. Each cell gives for cur attempts and cur eggs max floors that can be tested. 
        #Time complexity - O(k*n) - where n - floors and k - eggs. n*k for iterating dp matrix
        #Space complexity - O(n*k) 

        dp = [[0]*(k+1) for i in range(n+1)]
        attempt = 0

        while dp[attempt][k]<n:
            attempt+=1
            for i in range(1, k+1):
                broken = dp[attempt-1][i-1] #attempt is used hence subtract 1, and egg is broken so subtract 1
                notBroken = dp[attempt-1][i] #attempt is used hence subtract 1, and egg is not broken remains same.
                dp[attempt][i] = 1 + broken + notBroken
        
        return attempt


#------------------------------------------OR---------------------------------------------

        #Here we use DP approach. We create dp matrix of k*n. For each cell i.e. no .of eggs vs no. of floors we calculate the min moves and store it for further use.
        #For each cell, all combinations of floors is calculated for broken egg and not broken egg case. The min of these cases is stored in the cell.
        #Time complexity - O(k*n^2) - where n - floors and k - eggs. n*k for iterating dp matrix and extra 'n' for computing all floors cases for each cell.
        #Space complexity - O(n*k) 
        dp = [[0]*(n+1) for i in range(k+1)]

        for j in range(1, n+1):
            dp[1][j] = j

        for i in range(2, k+1):
            for j in range(1, n+1):

                minval = math.inf
                
                for f in range(1, j+1):
                    broken = dp[i-1][f-1] #egg is broken so subtract 1, remaining floors is floors below cur 
                    notBroken = dp[i][j-f] #egg is not broken remains same, floors is total floors minus cur floor
                    minval = min(minval, 1+max(broken, notBroken))
                dp[i][j] = minval
        
        return dp[k][n]