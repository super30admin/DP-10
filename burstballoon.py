# Time complexity - O(k*n^2)
# Space complexity - O(kn)
# Did this solution run on leetcode? - yes
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        if n==0: return 0
        
        # dp array to keep track of coins 
        dp = [[0 for _ in range(n)] for _ in range(n)]
        
        for i in range(1, n+1):  `                                      # O(n)
            for j in range(n-i+1):                                      # O(n)
                end_idx = j+i-1           # end index of each subarray
                
                # left, right - values of the coins to the left and right of the current value in the array (balloons which have not been bursted yet).
                for k in range(j, end_idx+1):                           # O(k)
                    left, right = 1, 1
                    if j!=0:
                        left = nums[j-1]
                    if end_idx!=n-1:
                        right = nums[end_idx+1]
                    
                    '''
                        Example - [3,1,5,8]
                        dp[0,3] = max(
                                    1*3*1 + dp[1,3], // burst the 1st balloon at the end.
                                1*1*1 + dp[0,0] + dp[2,3], // burst the 2nd balloon at the end.
                                1*5*1 + dp[0,1] + dp[3,3], // burst the 3rd balloon at the end.
                                1*8*1 + dp[0,2]     // burst the 4th balloon at the end.
                                )
                    '''
                    before, after = 0, 0
                    # value of the coins collected by bursting balloons present in the nums before the current balloon.
                    if k!=j:
                        before = dp[j][k-1]
                    # value of the coins collected by bursting balloons present in the nums after the current balloon.
                    if k!=end_idx:
                        after = dp[k+1][end_idx]
                    
                    dp[j][end_idx] = max(dp[j][end_idx], before + left*nums[k]*right + after)
        
        return dp[0][n-1]
        