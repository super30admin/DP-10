# Problem1: Super Egg Drop (https://leetcode.com/problems/super-egg-drop/)
# Time Complexity: O(n * k),the while loop runs at most n times since attempts cannot exceed n and for each attempt we loop through all k eggs, so total work is n * k
# Space Complexity: O(n * k),dp table has (n+1) rows and (k+1) columns, so it uses space proportional to n * k
# Approach:
# instead of asking "minimum drops for n floors", we flip the question to "with this many drops and eggs, what is the max floors I can cover for certain" dp[i][j] means the max floors we can check with i attempts and j eggs we keep increasing attempts until dp[attempts][k] covers at least n floors

class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        # dp[i][j] = max floors coverable with i attempts and j eggs
        # start all at 0 since with 0 attempts we cannot cover any floors
        dp = [[0] * (k + 1) for _ in range(n + 1)]

        # attempts is our counter, we increase it until we cover enough floors
        # this will also be our final answer
        attempts = 0

        # keep going as long as our current attempts with all k eggs
        # cannot cover all n floors yet
        while dp[attempts][k] < n:
            # try one more drop
            attempts += 1

            # recompute max floors coverable for this new attempt count,
            # for every possible number of eggs from 1 to k
            for j in range(1, k + 1):
                # 1 is the floor we are testing right now
                # dp[attempts-1][j-1] is floors below, if egg breaks (lose an egg, use a drop)
                # dp[attempts-1][j] is floors above, if egg survives (keep eggs, use a drop)
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j]

        # once the while loop stops, dp[attempts][k] >= n
        # meaning attempts is the minimum drops needed to cover all n floors
        return attempts