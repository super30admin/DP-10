# Problem 2 : Burst Balloons
# Time Complexity : O(n^3) where n is the n is the size of nums list
# Space Complexity : O(n^2) where n is the n is the size of nums list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        # if the nums array is None or length of the array is 0 then return 0 
        if nums is None or len(nums) == 0:
            return 0
        # get the length of the nums array
        length = len(nums)
        # define dp matrix with size (length)(length) and fill with 0
        dp = [[0 for _ in range(length)] for _ in range(length)]
        # burstible array
        # loop from 1 to (length+1)
        for leng in range(1, length+1):
            # start of the burstible array i isstart of burstible array
            # loop from 1 to (original length -leng + 1)
            for i in range(length - leng+1):
                # get the value of j as (i+leng-1)
                j = i + leng - 1
                # set the maxValue to (-inf)
                maxValue = float('-inf')
                # loop from i to (j+1)
                for k in range(i, j+1):
                    # kth ballon in end
                    # define the left and set to 0
                    left = 0 
                    # check if i is not equal to k
                    if i != k:
                        # if it is not then set left to the value of dp at i and (k-1)th position
                        left = dp[i][k-1]
                    # define the right and set to 0
                    right = 0
                    # check if j not equal to k
                    if j != k:
                        # if it is not equal then set right to the value of dp at (k+1) and jth position
                        right = dp[k+1][j]
                    
                    # kth
                    # define and set before to 1
                    before = 1
                    # if i is not equal to 1
                    if i != 0:
                        # then set the before to value of nums at (i-1)th position
                        before = nums[i-1]
                    # define and set after to 1
                    after = 1
                    # check if j is not equal to (length-1)
                    if j != (length - 1):
                        # set the after to the value of nums at (j+1)th position
                        after = nums[j+1]
                    # calculate the curr as left already burst + before * kth * after + right already burst
                    curr = left + before*nums[k]*after + right
                    # get the maximum between  maxValue and curr and set the maxValue 
                    maxValue = max(maxValue, curr)
                # set the value of dp at i and jth position with maxValue
                dp[i][j] = maxValue

        # return the value of dp at 0 and (length-1)th position
        return dp[0][length-1]
