"""
Time complexity =O(N^3)
Space complexity= O(N*N)

dp array holds column and rw index of coins in nums and saves max coin value collected bursting a particular ballooon at end. 
"""

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if (nums == None or len(nums) == 0):
            return 0
        nums = [1] + nums + [1]
        #print(nums)
        n = len(nums)
        dp = [[0 for i in range(n)] for j in range(n)]
        #print(dp)
        for len1 in range(2, n): #size of the subarray 
            for i in range(0, n - len1):#fist index of subarry  
                j = i + len1 #last index [...i....j...]
                for k in range(i+1, j):#iterate through i and j 
                    before = dp[i][k]
                    after=dp[k][j]
                    leftVal, rightVal = nums[i], nums[j]
                    dp[i][j] = max(dp[i][j], before + (leftVal * nums[k] * rightVal) + after) #before and after from subarray 
        return dp[0][n - 1]