class Solution:
    def maxCoins(self, nums: List[int]) -> int:

        ## T.C = O(n^3)
        ## S.C = O(n^2)

        if not nums:
            return 0
        
        n = len(nums)
        dp = [[0]*n for i in range(n)]

        for ln in range(1, n+1):
            for i in range(0, n - ln + 1):
                j = i + ln - 1

                for k in range(i, j+1):
                    left = right = 0
                    if k != i:
                        left = dp[i][k-1]
                    if k != j:
                        right = dp[k+1][j]
                    
                    before = after = 1
                    if i != 0:
                        before = nums[i-1]
                    if j != n-1:
                        after = nums[j+1]
                    
                    print('left: ',left, 'right: ', right, 'before: ', before, 'after: ', after, 'k: ', nums[k])
                    dp[i][j] = max(dp[i][j], left + (before * nums[k] * after) + right)
                    print(dp)
            print('---------------------------')
        
        return dp[0][n-1]
