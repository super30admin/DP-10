'''
Time Complexity --> O(n^3)
Space Complexity --> O(n^2)
'''
class Solution:
     def maxCoins(self, nums: List[int]) -> int:
        dp = [[-1 for _ in range(len(nums))] for _ in range(len(nums))]

        for k in range(len(nums)):
            for i in range(len(nums) - k):
                j = i + k
                left = nums[i - 1] if i > 0 else 1
                right = nums[j + 1] if j < len(nums) - 1 else 1
                if i == j:
                    dp[i][j] = left * right * nums[i]
                    continue
                r = 0
                for d in range(i, j + 1):
                    sub_left = dp[i][d - 1] if d - 1 >= i else 0
                    sub_right = dp[d + 1][j] if d + 1 <= j else 0
                    r = max(r, sub_left + sub_right + left * right * nums[d])
                dp[i][j] = r
        return dp[0][-1]
        
