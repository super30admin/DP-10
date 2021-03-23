#Time Complexity:O(n^3)
#space Complexity:O(n^2)
#Approach:Append 1 at the beginning and end of the array ,Create a dp array that saves the max coins for various possible balloon combinations/
#subproblems.Return the max coins at the end. 
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if (nums == None or len(nums) == 0):
            return 0
        nums = [1] + nums + [1]
        n = len(nums)
        dp = [[0 for i in range(n)] for j in range(n)]
        for l in range(2, n):
            for i in range(0, n - l):
                j = i + l
                for k in range(i+1, j):
                    left, right = nums[i], nums[j]
                    before, after = dp[i][k], dp[k][j]
                    curr = before + (left * nums[k] * right) + after
                    dp[i][j] = max(dp[i][j], curr)
        return dp[0][n - 1]