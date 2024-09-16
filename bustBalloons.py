'''
Time Complexity: O(n^2)
Space Complexity: O(n^2)
Did this code successfully run on Leetcode : Yes
Explanation: for every subproblem find the leftgain and right gain if we did not pop the balloon multiplied by the current gain
'''

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        n = len(nums)
        gain = [[0 for i in range(n)] for j in range(n)]
        for length in range(1, n + 1):
            for i in range(0, n - length + 1):
                # size = e - s +1
                # size = s - 1 = i +len-1
                j = i + length - 1

                for k in range(i, j + 1):
                    leftGain = 0
                    rightGain = 0
                    if k != i:
                        leftGain = gain[i][k - 1]
                    if k != j:
                        rightGain = gain[k + 1][j]

                    leftBalloonValue = rightBalloonValue = 1

                    if i != 0:
                        leftBalloonValue = nums[i - 1]

                    if j != n - 1:
                        rightBalloonValue = nums[j + 1]

                    selfValue = leftGain + leftBalloonValue * nums[k] * rightBalloonValue + rightGain
                    gain[i][j] = max(gain[i][j], selfValue)

        return gain[0][n - 1]