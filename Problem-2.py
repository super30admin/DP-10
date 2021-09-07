"""
TC: O(n^3)
SC: O(n^2)
"""
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [[0]* (n) for _ in range(n)]
        
        for eff_len in range(1, n+1): # length of effective list of burstable balloons
            for start in range(n - eff_len + 1): # starting index of effective list, including the last starting index
                end = start + eff_len - 1 # ending index
                for curr_last in range(start, end+1):
                    if start > end: continue # compute only the top half of diagonal
                    # values for balloons at start and end indices
                    left_earnings, right_earnings = 0,0
                    left_value, right_value = 1,1
                    
                    # these valus will change for balloons at middle indices 
                    if curr_last != start:
                        left_earnings = dp[start][curr_last -1]
                    if curr_last != end:
                        right_earnings = dp[curr_last + 1][end]
                    if start != 0:
                        left_value = nums[start -1]
                    if end != n-1:
                        right_value = nums[end +1]
                    curr_earnings = left_value * nums[curr_last] * right_value
                    dp[start][end] = max(dp[start][end], left_earnings + curr_earnings + right_earnings)
        return dp[0][-1] #effective array == given array