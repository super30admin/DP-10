// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
In this problem 
a) we start slicing the input array using the len1 paraemter as in we start from 1 and keep on incrementing.
b)for every slice we set the start and end position.
c)for every slice we tarverse and calculate the left and right gains and the given element value and find the max gain of that slice.
d)In this way we calculate the gain for all the slices using the previous calculated slices gains.
e) In the end we get the result at the corner column first row.

# Time complexity --> o(n*n*n)
# space complexity --> o(n*n)
class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums==None or len(nums)==0:
            return 0
        n=len(nums)
        out=[[0 for i in range(n)]for j in range(n)]
        len1=1
        #we start by slicing the input based on the length i.e from len1 to n
        while len1<=n:
            #we are setting the start position with i for every slice.
            for i in range(n-len1+1):
                # len1=e-i+1
                # e=len1+i-1
                #setting the end position for every start i.e if the len is 2 and start is 1 then end will be 2 using size=end-start+1 formula
                j=len1+i-1
                #for every slice that we get we have traverse again to get the gain at each ballon we do that using k
                for k in range(i,j+1):
                    leftgain=0
                    rightgain=0
                    #if the index i is at the edge then it has no left element so the left gain is 0 .except for the left edge elements all other elements has left elements so we can get left gain.
                    if k!=i:
                        leftgain=out[i][k-1]
                    #if the index j is at the edge then it has no right element so the right gain is 0 .except for the right edge elements all other elements has right elements so we can get right gain.
                    if k!=j:
                        rightgain=out[k+1][j]
                    #When we blast the ballon at the index k then the value is considered to be element left of the given element multipled with right of the given elemenet and the given element.
                    #If the ballon at the edge is blasted then left and right ballon values will be 1.
                    leftballonval=1
                    rightballonval=1
                    if i!=0:
                        leftballonval=nums[i-1]
                    if j!=n-1:
                        rightballonval=nums[j+1]
                    #for every slice at every element in the slice we calculate the gain so we are taking the max gain out of #those
                    out[i][j]=max(out[i][j],leftgain+(leftballonval*nums[k]*rightballonval)+rightgain)
            len1=len1+1
            # print(out)
        return out[0][n-1]