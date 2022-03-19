'''

TC: O(n^3)
SC: O(n^2)

'''
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        nlen = len(nums)
        if not nlen:
            return 0
        
        dp = [[0 for _j in range(nlen)] for _i in range(nlen)]
        
        for lenx in range(1, nlen + 1):
            for i in range(nlen - lenx + 1):
                j = i + lenx - 1
                left = 1
                right = 1

                if i - 1 >= 0:
                    left = nums[i - 1]
                if j + 1 < nlen:
                    right = nums[j + 1]
                    
                for k in range(i, j + 1):
                    dp[i][j] = max(dp[i][j], (dp[i][k-1] if k - 1 >= i else 0) + (left * nums[k] * right) + (dp[k + 1][j] if k + 1 <= j else 0))
        
        return dp[0][nlen - 1]