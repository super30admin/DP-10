# Time complexity: O(n^2 * k). Since we are doing all the permutations we have to try with each egg
# Space is O(n*k)

# The intuition is to use a dynamic programming approach to determine the results of the sub problems, for example with one egg we have to
# try each and every floor exhaustively. Then for n number of floors and k eggs we can determine the others.

class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[0] * (n + 1) for _ in range(k + 1)]

        for j in range(1, n + 1):
            dp[1][j] = j

        for i in range(2, k + 1):
            for j in range(1, n + 1):
                minVal = float("inf")
                for f in range(1, j + 1):
                    curr = 1 + max(dp[i - 1][f - 1], dp[i][j - f])
                    minVal = min(curr, minVal)
                dp[i][j] = minVal

        return dp[k][n]

# Time complexity: O(n*k) this is a more efficient algorithm. Here we created a DP using attempts vs k(number of eggs). Here we try to determine
# with each attempt left or used and number of eggs how many floors can we cover. If we find out we have reached equal to or greater than n floors
# Then we can return the number of attempts as the result
class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[0] * (k + 1) for _ in range(n + 1)]

        attempts = 0

        while (dp[attempts][k] < n):
            attempts += 1
            for j in range(1, k + 1):
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j]

        return attempts