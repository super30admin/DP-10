class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [[0] * (n) for _ in range(n)]

        # bursitble array
        for le in range(1,n+1):
            #start of the burstible array and the end\\
            #j i sthe start of burstible array
            for i in range((n-le)+1):
                #end of busrstible array
                j = i + le-1
                maxVal = float("-inf")
                for k in range(i,j+1):
                    #kth balloon in the end
                    left = 0
                    if i != k:
                        left = dp[i][k-1]

                    right = 0
                    if j != k:
                        right = dp[k+1][j]
                    
                    #kth balloon 
                    #left already burst + before *at balloon*after + right already burst

                    before = 1
                    if i != 0:
                        before = nums[i-1]
                    

                    after = 1
                    if j != n-1:
                        after = nums[j+1]
                    
                    curr = left + (before * nums[k] * after) + right
                    maxVal = max(maxVal, curr)

                dp[i][j] = maxVal


        return dp[0][n-1]