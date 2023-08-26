#Time complexity is O(nk)
#Space complexity is O(nk)
#No issues faced while coding
#Code ran successfully on leetcode
class Solution(object):
    def superEggDrop(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: int
        """
        #Initializing the array and attempts
        dp=[[0 for i in range(k+1)] for j in range(n+1)]
        attempts=0
        #We will loop until the number of attempts is less than floors
        while(dp[attempts][k]<n):
            #We will increase the attempts by 1
            attempts+=1
            #We will calculate the maximum number of floors that we can check
            #For the given number of attempts
            for j in range(1,k+1):
                dp[attempts][j]=1+dp[attempts-1][j-1]+dp[attempts-1][j]
        #Finally we will return attempts.
        return attempts
