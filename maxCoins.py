class Solution:
    def (self, nums: List[int]) -> int:
        if not nums:
            return nums
        
        dp = [[0]*len(nums) for _ in range(len(nums))]
        
        
        for length in range(1, len(nums)+1):
            for i in range(len(nums)-length+1):
                j = i+length-1
                for currentSelection in range(i,j+1):
                    
                    left = 1
                    right = 1
                    
                    if i!=0:
                        left = nums[i-1]
                    if j!=len(nums)-1:
                        right = nums[j+1]
                        
                    before, after  = 0, 0
                    
                    if currentSelection!=i:
                        before = dp[i][currentSelection-1]
                    if currentSelection!=j:
                        after = dp[currentSelection+1][j]
                    
                    dp[i][j] = max(dp[i][j], before + left * nums[currentSelection] * right + after)          
        return dp[0][len(nums)-1]
            
TIme: O(N3)
Space: (MN)
