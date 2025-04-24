# https://leetcode.com/problems/burst-balloons/

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0
        n = len(nums)
        dp = [[0] * (n) for _ in range(n)]

        for le in range(1,n+1): # length of the burstible arr to be considered
            # start of the burstible bubble/arr
            for i in range(0,n-le+1):
                # end  of the burstible bubble/arr
                j = i + le - 1
                
                max_val = float('-inf')
                for k in range(i,j+1): # for all the elements in the arr considering them as the last balloon that is to be popped
                    # for kth balloon in the end
                    left = 0
                    if i!=k:
                        left = dp[i][k-1]
                    
                    right = 0
                    if j!=k:
                        right = dp[k+1][j]

                    before = 1
                    if i!=0:
                        before = nums[i-1]
                    
                    after = 1
                    if j!= n-1:
                        after = nums[j+1]
                    
                    # left + (before * nums[k] * after) + right

                    curr = left + (before * nums[k] * after) + right
                    max_val = max(max_val,curr)
                
                dp[i][j] = max_val
        
        return dp[0][n-1]

# TC: O(n^3)
#SC: O(n^2)        