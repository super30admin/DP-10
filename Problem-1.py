# Time Complexity : O(K * N)  # DP where moves grow until floors covered >= N
# Space Complexity : O(K)     # Only one DP array for eggs
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# dp[k] represents maximum floors that can be checked with k eggs and m moves.
# Recurrence: dp[k] = dp[k] + dp[k-1] + 1 (egg survives + egg breaks + current floor).
# Increase moves until dp[K] >= N floors.

class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [0]*(k+1)
        moves = 0

        while dp[k] < n:
            moves += 1
            for i in range(k,0,-1):
                dp[i] = dp[i] + dp[i-1] + 1

        return moves