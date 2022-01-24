# Space: O(n*n)
# Time: O(n*n*n)
class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        dp = [[0 for i in range(len(nums))] for j in range(len(nums))]
        for i in range(1, len(nums)+1):
            for start in range(len(nums) - i+1):
                end = start + i - 1
                for delete_at_last in range(start, end+1):
                    # (start to delete_at_last - 1) + (start-1 * delete_at_last * end+1) + (delete_at_last+1 to end)
                    left = 0
                    right = 0
                    left_mult = 1
                    right_mult = 1
                    if delete_at_last != start:
                        left = dp[start][delete_at_last - 1]
                    if start != 0:
                        left_mult = nums[start-1]
                    if end != len(nums) - 1:
                        right_mult = nums[end+1]
                    if delete_at_last != end:
                        right = dp[delete_at_last+1][end]
                    dp[start][end] = max(dp[start][end], left+(left_mult*nums[delete_at_last]* right_mult)+right)
        return dp[0][len(nums) - 1]
