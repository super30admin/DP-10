class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        # Time complexity: O(N^3), where N is the number of elements in the input list.Nested loops iterate over different subarrays of the input.
        # Space complexity: O(N^2), as the 2D dp array has dimensions (N+2) x (N+2).
        n = len(nums)

        # Add boundary balloons with values 1 to handle edge cases
        nums = [1] + nums + [1]

        # Initialize a 2D dp array with all values set to 0
        dp = [[0] * (n + 2) for _ in range(n + 2)]

        # Iterate over different lengths of subarrays
        for length in range(1, n + 3):
            for start in range(n - length + 3):
                end = start + length - 1
                maximum = 0

                # Try each position as the last balloon to be burst
                for k in range(start + 1, end):
                    before = nums[start]
                    after = nums[end]
                    left = dp[start][k]
                    right = dp[k][end]

                    # Calculate the score for the current position
                    score = before * nums[k] * after
                    total = left + score + right

                    # Update the maximum score
                    maximum = max(maximum, total)

                # Store the maximum score for the current subarray
                dp[start][end] = maximum

        # The final result is the maximum score for the entire array
        return dp[0][n + 1]
