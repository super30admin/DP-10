# Time Complexity : O(n^3) 
# Space Complexity :O(n^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# # backtrack solution:
# class Solution:
#     result = None 
#     def maxCoins(self, nums):
#         self.result = 0
#         self.backtrack(nums, 0)
#         return self.result 
    
#     def backtrack(self, nums, curr_sum) : 
#         # base 
#         if len(nums) == 0:
#             return curr_sum
#         # logic 
#         for i in range(len(nums)):
#             key = nums[i]
#             left, right = 1, 1 
#             if i == 0:
#                 left =  1
#             else:
#                 left = nums[i-1]
                
#             if i == len(nums)-1 :
#                 right = 1 
#             else:
#                 right = nums[i+1]
            
#             # action 
#             nums.pop(i)
#             # recurse
#             self.result = max(self.result, self.backtrack(nums, curr_sum + (left*key*right)))
#             # backtrack
#             nums.insert(i, key)
            
#         return self.result

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0 
        n = len(nums)
        dp = [[0 for _ in range(n)] for _ in range(n)]
        
        for level in range(1, n+1):
            for i in range(0, n-level+1):
                j = i+level-1
                
                for k in range(i, j+1):
                    left, right, before, after = 1, 1, 0, 0
                    
                    if i > 0:
                        left = nums[i-1]
                    
                    if j < n-1:
                        right = nums[j+1]
                    
                    if k != i:
                        before = dp[i][k-1]
                    
                    if k != j:
                        after = dp[k+1][j]
                    
                    dp[i][j] = max(dp[i][j], before + (left * nums[k] * right) + after)
        
        return dp[0][-1]
                        
if __name__ == "__main__":
    s = Solution()
    res = s.maxCoins([3,1,5,8])
    assert res == 167