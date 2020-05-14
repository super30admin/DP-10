'''
Time Complexity: O(n^2)
Space Complexity: O(n^2)
Did this code successfully run on Leetcode : Yes
Explanation: for every pivot point attempt floors[attempt][k] = 1 + floors[attempt - 1][k - 1] + floors[attempt - 1][k] and if we
ever increase more than the max number of eggs with us then return the attempt
'''
class Solution:
    # optimised
    def superEggDrop(self, K: int, N: int) -> int:
        floors = [[0 for i in range(K + 1)] for j in range(N + 1)]

        for attempt in range(1, N + 1):
            for k in range(1, K + 1):
                floors[attempt][k] = 1 + floors[attempt - 1][k - 1] + floors[attempt - 1][k]
                if floors[attempt][k] >= N:
                    return attempt

        return N

    # TLE as O(KN^2)
    def superEggDropNormal(self, K: int, N: int) -> int:
        attempts = [[0 for i in range(N + 1)] for j in range(K + 1)]

        for f in range(1, N + 1):
            attempts[1][f] = f

        for k in range(2, K + 1):
            for n in range(1, N + 1):
                attempts[k][n] = math.inf
                for f in range(1, n + 1):
                    attempts[k][n] = min(attempts[k][n], 1 + max(attempts[k - 1][f - 1], attempts[k][n - f]))

        return attempts[K][N]