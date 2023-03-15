#time O(N*N)
#space O(N)
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        nums = [1] + nums + [1]
        n = len(nums)
        dp = [[0] * n for _ in range(n)]
        
        # Iterate the input array in reverse order to fill the dp table
        for i in range(n-2, -1, -1):
            for j in range(i+2, n):
                # Iterate k from i+1 to j-1 to find the last balloon to burst
                for k in range(i+1, j):
                    # Compute the maximum coins for subproblems
                    dp[i][j] = max(dp[i][j], nums[i]*nums[k]*nums[j] + dp[i][k] + dp[k][j])
        
        return dp[0][n-1]