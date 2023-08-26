#Time complexity is O(n^3)
#Space complexity is O(n^2)
#Code ran suceessfully on leetcode
#No issues faced while coding
class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #Base condition
        if(nums==None or len(nums)==0):
            return 0
        #Initializing all the required variables
        n=len(nums)
        dp=[[0 for i in range(n)] for i in range(n)]
        #Looping through all the values in the given nums array
        for l in range(1,n+1):
            #start index of the burstible array
            for i in range(0,n-l+1):
                #i is the starting index
                #end index of the burstible array, j is the end index
                j=i+l-1
                #Taking the maxi value as the minimim infinity
                maxi=-1*float('inf')
                #Looping the array under consideration
                for k in range(i,j+1):
                    #Taking left and right values
                    left=0
                    right=0
                    if(i!=k):
                        #If the above condition satisfies, below one will be left value
                        left=dp[i][k-1]
                    if(j!=k):
                        #If the above condition satisfies, below one will be left value
                        right=dp[k+1][j]
                    #Initialzing before and after values
                    before=1
                    after=1
                    if(i!=0):
                        #If the above condition satisfies, below one will be before value
                        before=nums[i-1]
                    if(j!=n-1):
                        #If the above condition satisfies, below one will be after value
                        after=nums[j+1]
                    #We will take the maxi mum value at each step
                    maxi=max(maxi,left+before*nums[k]*after+right)
                #FInally we will update the dp matrix with maximum value
                dp[i][j]=maxi
        #We will return value in the first row last clomun
        return dp[0][n-1]


