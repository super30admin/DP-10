"""
Use DP to solve subproblems: dp[i][j] = max coins from bursting balloons between i and j (exclusive)
Try every k in (i, j) as the last balloon to burst and combine results of left and right
Add 1 padding on both ends to simplify edge cases
"""
"""
Time Complexity: O(n^2)	3 nested loops
Space Complexity: O(n^2) For DP table
"""

class superEgg:
    def maxCoins(self, nums: list[int]) -> int:
        nums = [1] + nums + [1]
        n = len(nums)
        dp = [[0] * n for _ in range(n)]

        for length in range(2, n):  # interval size
            for left in range(0, n - length):
                right = left + length
                for k in range(left + 1, right):
                    dp[left][right] = max(dp[left][right],
                        nums[left] * nums[k] * nums[right] +
                        dp[left][k] + dp[k][right])
        return dp[0][n - 1]

if __name__ == "__main__":
    obj = superEgg()
    print(obj.maxCoins([3, 1, 5, 8]))  # 167
    print(obj.maxCoins([1, 5]))        # 10
    print(obj.maxCoins([7, 9, 8, 0, 7, 1, 3, 5, 5, 2, 3])) 
