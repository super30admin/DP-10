'''
T = O(n^3)
S = O(n^2)

Approach:
this is a bottom up dp approach. We find the order by evaluavating which ballon to first at the end instead of in the first
1.first check the coins obtained by just busting one ballon at the end so these wont have a previously burst or after burst
2.do the same for more than 1 ballon hence at every combination there will be a before and an after burst value
3. the before and after bursts can be found using the maintained dp array
4. the value at the top of the dp matrix will give the cost and in order to get the order follow the maximum trail at every step
'''


class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if (nums == None or len(nums) == 0):
            return 0
        nums = [1] + nums + [1]
        n = len(nums)
        dp = [[0 for i in range(n)] for j in range(n)]
        for length in range(2, n):
            for i in range(0, n - length):
                j = i + length
                for k in range(i+1, j):
                    before, after = dp[i][k], dp[k][j]
                    leftVal, rightVal = nums[i], nums[j]
                    curr = before + (leftVal * nums[k] * rightVal) + after
                    dp[i][j] = max(dp[i][j], curr)
        return dp[0][n - 1]