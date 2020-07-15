'''
Solution:
1.  The problem is similar to matrix chain multiplication where we calculate cell, the optimal value ranging all
    combinations of range of indices from length 1 to length n.
2.  For a particular cell or subproblem, we calculate max of all possible combinations of a particular length,
    keeping left max value and right max value as 1 if out of bounds on the corresponding sides.
3.  This means that we fill the matrix diagonally of varying lengths.

Time Complexity:    O(n*n*n)
Space Complexity:   O(n*n)

--- Passed all testcases successfully on leetcode.
'''


class Solution:
    def maxCoins(self, nums: List[int]) -> int:

        #   edge case check
        if (nums == None or len(nums) == 0):
            return 0

        #   initializations and base cases
        n = len(nums)
        gain = [[0 for i in range(n)] for j in range(n)]

        #   iterate for all lengths
        for length in range(1, n + 1):

            #   for each i from 0 to n - current length
            for i in range(0, n - length + 1):
                j = i + length - 1              #   fixate the value of j using i and current length

                maxGain = 0                     #   calculate max gain for the entire j values for each i
                for k in range(i, j + 1):

                    leftGain = 0
                    rightGain = 0

                    if (k != i):                #   update left gain if i and k not equal
                        leftGain = gain[i][k - 1]
                    if (k != j):                #   update right gain if k and j not equal
                        rightGain = gain[k + 1][j]

                    leftBalloonValue = 1
                    rightBalloonValue = 1

                    if (i != 0):                #   if not out of bounds => update left balloon value
                        leftBalloonValue = nums[i - 1]
                    if (j != n - 1):            #   if not out of bounds => update right balloon value
                        rightBalloonValue = nums[j + 1]

                    #   calculate current value
                    currentValue = leftGain + (leftBalloonValue * nums[k] * rightBalloonValue) + rightGain

                    #   update current cell (i, j)
                    gain[i][j] = max(gain[i][j], currentValue)

        # return gain for indices 0 to n-1
        return gain[0][n - 1]