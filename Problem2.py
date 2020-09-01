"""
time : o(n^3)
space : o(n^2)
"""
class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        
        dp = [[0 for i in range(len(nums))] for j in range(len(nums))]
        
        for cur_len in range(1,len(nums) + 1): #the length of substring considered at a point
            
            for i in range(0, len(nums) - cur_len + 1):
                j = i + cur_len - 1 # sub array being considered
                
                for k in range(i,j + 1):
                    left = 1
                    right = 1
                    if j != len(nums) -1 :
                        right = nums[j + 1] # cost of right side
                    if i != 0:
                        left = nums[i - 1] # cost of left side
                        
                    before, after = 0, 0
                      
                    if k != i:
                        before = dp[i][k-1] # cost of bursting balloons on the left
                    
                    if k != j:
                        after = dp[k+1][j] # cost of bursting balloons on the right
                    
                    dp[i][j] = max(dp[i][j], before + left * nums[k] * right +after)
        return dp[0][len(nums) -1 ]