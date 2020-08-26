# Time Complexity :O(N^3)
# Space Complexity :O(N^2) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : yes, include last j
class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        n = len(nums)#length array
        dp = [[0]*n for i in range( n)]#dp array of N^2
        for length in range(1,n+1):#all lengths
            for i in range(0,n-length+1):#from 0 to n- length
                j = i+length-1#j is end of the sub array
                for k in range(i,j+1):#traverse sub array
                    left = 1 #left of number
                    right = 1 #right of number
                    
                    if j != n-1:#if j != end of array
                        right = nums[j+1] #change right
                    if i !=0:#if i != start of array
                        left = nums[i-1] #change left

                    before= 0 #max of left sub array
                    after = 0 #max of right subarray
                    if k!=i:#k != start of array
                        before = dp [i][k-1]
                    if k!=j: # k != end of subarray
                        after = dp[k+1][j]
                    dp[i][j] = max(dp[i][j], (before+ left*nums[k]*right +after)) #get max of old and current
        
        return dp[0][-1] #return anser