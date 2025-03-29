class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        # T: O(k log n), S: O(k)
        dp = [0] * (k + 1)
        moves = 0
        while dp[k] < n:
            moves += 1
            for i in range(k, 0, -1):
                dp[i] = dp[i - 1] + dp[i] + 1
        return moves
