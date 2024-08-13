# Time Complexity : O(k*n)
# Space Complexity : O(k*n)
class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[0] * (n + 1) for _ in range(k + 1)]
        m = 0
        while dp[k][m] < n:
            m += 1
            for i in range(1, k + 1):
                dp[i][m] = dp[i - 1][m - 1] + dp[i][m - 1] + 1
        return m

# Examples
solution = Solution()

# Example 1
k1, n1 = 1, 2
result1 = solution.superEggDrop(k1, n1)
print("Example 1: k = {}, n = {} -> Minimum attempts = {}".format(k1, n1, result1)) # Example 1: k = 1, n = 2 -> Minimum attempts = 2

# Example 2
k2, n2 = 2, 6
result2 = solution.superEggDrop(k2, n2)
print("Example 2: k = {}, n = {} -> Minimum attempts = {}".format(k2, n2, result2)) # Example 2: k = 2, n = 6 -> Minimum attempts = 3

# Example 3
k3, n3 = 3, 14
result3 = solution.superEggDrop(k3, n3)
print("Example 3: k = {}, n = {} -> Minimum attempts = {}".format(k3, n3, result3)) # Example 3: k = 3, n = 14 -> Minimum attempts = 4