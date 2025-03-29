class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        # T: O(n ** 3), S: O(n ** 2)
        nums = [1] + nums + [1]  # Add boundary 1s
        n = len(nums)
        dp = [[0] * n for _ in range(n)]

        for length in range(1, n - 1):  # Subarray length
            for left in range(1, n - length):  # Left boundary
                right = left + length - 1  # Right boundary
                for i in range(left, right + 1):  # Pick last burst balloon
                    dp[left][right] = max(
                        dp[left][right],
                        dp[left][i - 1]
                        + nums[left - 1] * nums[i] * nums[right + 1]
                        + dp[i + 1][right],
                    )

        return dp[1][n - 2]
