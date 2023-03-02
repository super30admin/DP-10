# Time Complexity: O(n^3)
# Space Complexity: O(n^2)

class Solution:
    # min_val = -2**32
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [[0 for i in range(n)] for j in range(n)]
        for leng in range(1, n+1):
            for i in range(n-leng+1):
                j = i + leng - 1
                for k in range(i, j+1):
                    # K is the index of the balloon burst in the end
                    # before +  left * curr * right  + after
                    # before -> already burst balloon on left of current balloon
                    # after -> already burst balloon on right of current balloon
                    # left -> left balloon not bursted in main arr
                    before = 0
                    after = 0
                    if k != i:
                        before = dp[i][k-1]

                    if k != j:
                        after = dp[k+1][j]

                    left = 1
                    right = 1
                    if i != 0:
                        left = nums[i-1]
                    if j != n-1:
                        right = nums[j+1]

                    dp[i][j] = max(dp[i][j], before +
                                   (left * nums[k] * right) + after)
        return dp[0][n-1]

#         def helper(currSum, arr):
#             #Base

#             self.min_val = max(currSum, self.min_val)
#             #Logic
#             for i in range(len(arr)):
#                 if i == 0: x = 1
#                 else: x = arr[i-1]
#                 if i == len(arr)-1: y = 1
#                 else: y = arr[i+1]
#                 val = currSum + (arr[i]*x*y)
#                 new = arr[:i] + arr[i+1:]
#                 # print(val, new)
#                 helper(val, new)

#         helper(0, nums)
#         return self.min_val
