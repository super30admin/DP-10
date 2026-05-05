# problem 2 

# https://leetcode.com/problems/burst-balloons/


class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        self.dp = [[0]*n for _ in range(n)]
        return self.helper(nums,0,n-1)

    def helper(self,nums,i,j):
        if i > j:
            return 0 
        if self.dp[i][j] != 0:
            return self.dp[i][j]
        max_val = 0 
        for k in range(i,j+1):
            before = self.helper(nums,i,k-1)
            after = self.helper(nums,k+1,j) 
            prev_val =1 
            next_val = 1
            if i > 0:
                prev_val = nums[i-1]
            if j < len(nums) -1:
                next_val = nums[j+1]
            selfBaloon = prev_val * next_val * nums[k]
            max_val = max(max_val,before+selfBaloon+after)
        self.dp[i][j] = max_val
        return max_val 