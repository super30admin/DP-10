# Time complexity : O(n^3)
# Space complexity : O(n^2)

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        # check for null case
        if not nums or len(nums) == 0:
            return 0
        
        # find the length of the nums list
        n = len(nums)
        
        # make a 2-d matrix and fill all of them as 0
        dp = [[0 for _ in range(n)]  for _ in range(n)]
        
        # we have to check for all permutations like array of size 1,2...n
        # array length
        for l in range(1,n+1):
            
            # starting index is always 0, and going up-till n - lenght of array that we are looking at
            # starting index
            for i in range(0,n-l+1):
                
                ## end index will always be starting index(i) + length of array(l) - 1 (for index)
                # ending index
                j = i + l - 1
                
                # at any point, to do the permutations, we are selecting each balloon to burst to check for the max amount
                # bursting kth balloon
                for k in range(i,j+1):
                    
                    #for the edge case first and last element, we are out of bound so we use 1 to multiply
                    left = 1
                    right = 1
                    
                    # if we not at the first starting index, then we can use the left as the element before the current
                    if i != 0:
                        left = nums[i-1]
                    
                    # if we not at the last index, then we can use the right as the element after the current
                    if j != n - 1:
                        right = nums[j+1]
                    
                    # value of permutation with respect to k th balloon
                    before = 0
                    after = 0
                    
                    # if k is not the starting index then before part is dp of starting index with k-1 th balloon
                    if k != i:
                        before = dp[i][k-1]
                    
                    # if k is not the last index then after part is dp of ending index with k-1 th balloon
                    if k != j:
                        after = dp[k+1][j]
                    
                    # dp[i][j] is set to the max of the existing value or the new value formed after calculations
                    dp[i][j] = max(dp[i][j], before + left * nums[k] * right + after)
        
        # return the last index in the first row as that is our final answer
        return dp[0][n-1]
