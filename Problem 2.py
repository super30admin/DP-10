# time complexity : O(len(nums)^2) BUT NOT SURE
# space complexity: O(len(nums)^2)

class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0

        # created a dp array of the maximum points at particular stage of busting
        coin_collected = [[0 for l in range(len(nums))] for m in range(len(nums))]

        # findings point that can be collected by bursting no. of ballons 1,2, ..... n gradually
        for length in range(1, len(nums) + 1):
            # starting from different ballons to start the process of bursting
            for start in range(len(nums) - length + 1):
                end = start + length - 1

                # deciding which ballon to burst the last
                for burst in range(start, end + 1):
                    leftvalue = 1
                    rightvalue = 1

                    # if we have some ballons ahead of start-end, then left will be the one before start and similartly for the right ballon
                    if (start != 0):
                        leftvalue = nums[start - 1]
                    if (end != len(nums) - 1):
                        rightvalue = nums[end + 1]

                    # within start-end ballons, if we have ballons bursted before and after k then find the points collected by them
                    before = 0
                    after = 0
                    if (start != burst):
                        before = coin_collected[start][burst - 1]
                    if (end != burst):
                        after = coin_collected[burst + 1][end]

                    # on each choice of last ballon, find the max points that can be collected
                    coin_collected[start][end] = max(coin_collected[start][end],
                                                     (leftvalue * nums[burst] * rightvalue + before + after))

        # the last column of thefirst row give the ans as it depicts length 0-n.
        return coin_collected[0][len(nums) - 1]