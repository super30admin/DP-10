# Problem2: Burst Balloon (https://leetcode.com/problems/burst-balloons/)
# Time Complexity: O(n^3),we have three nested loops, one for window length, one for start index i and one for choosing the last balloon k, each going up to n
# Space Complexity: O(n^2),we use a 2D dp table of size n by n to store the best answer for every possible range
# Approach:
# We think about which balloon gets popped last inside a range, instead of first
# If a balloon is popped last in a range, all other balloons in that range are already gone, so its neighbors are whatever is just outside the range
# We solve small ranges first, then use those answers to build up bigger ranges, until we get the answer for the full array

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [[0]*n for _ in range(n)]  # dp[i][j] will hold the max coins from popping all balloons between index i and j

        for sub_array in range(1, n + 1):  # try every window length, starting small and going up to the full array
            for i in range(n - sub_array + 1):  # slide the start of the window across the array
                j = i + sub_array - 1  # end of the window, based on start i and the current length

                for k in range(i, j + 1):  # try every balloon in this window as the last one popped
                    before_num = dp[i][k-1] if i != k else 0  # best score for the left leftover part, 0 if k is at the start
                    after_num = dp[k+1][j] if j != k else 0  # best score for the right leftover part, 0 if k is at the end

                    prev = nums[i-1] if i > 0 else 1  # balloon just outside the window on the left, or 1 if we are at the edge
                    next = nums[j+1] if j < n - 1 else 1  # balloon just outside the window on the right, or 1 if we are at the edge

                    ballon_itself = prev * nums[k] * next  # coins earned from popping k last, using outside neighbors

                    dp[i][j] = max(dp[i][j], before_num + ballon_itself + after_num)  # keep the best choice of last balloon for this window

        return dp[0][n-1]  # final answer is the best score for the whole array
