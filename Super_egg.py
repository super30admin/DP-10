// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
The logic to start with is for every floor we have to consider the probability of egg being broken and the egg being not broken.
i.e for every floor we consider the possibilities with the given number of eggs.
But the above approach leads to a more time complexity and gives Time limit exceeded when more number of floors are given to be evaluated.
So we do it with the number of attempts and the given number of eggs so that we can calculate the total number of floors to be explored.So for every attempt and the given number of eggs we calculate the number of floors to be explored in a given attempt and a given egg.In this way we calculate the floor to be explored for all the given cases.If the floors explored reaches the limit of the total number of floors then we return the required attempts.

# Time complexity --> o(n*k)
# space complexity --> o(n*k)
class Solution(object):
    def superEggDrop(self, K, N):
        """
        :type K: int
        :type N: int
        :rtype: int
        """
        #constructing a matrix where the rows is number of attempts taken and columns are the number of eggs.
        out=[[None for i in range(K+1)]for j in range(N+1)]
        for i in range(K+1):
            out[0][i]=0
        for j in range(N+1):
            out[j][0]=0
        for i in range(1,N+1):
            for j in range(1,K+1):
                #each cell in the matrix represents the floors that can be explored.The below formula is 1+(when the egg break)+(when it doesnot break) and 1 is for the move intiated.
                out[i][j]=1+out[i-1][j-1]+out[i-1][j]
                #if the cell value is greater than the number of total floors then we return the number of attempts.
                if out[i][j]>=N:
                    return i
        return N
        