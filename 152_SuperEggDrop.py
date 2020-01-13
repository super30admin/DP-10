'''
Accepted on leetcode(887)
time - O(M*N)
space - O(M*N)
'''


class Solution:
    def superEggDrop(self, K: int, N: int) -> int:
        dp = [[0 for i in range(K + 1)] for i in range(N + 1)]

        # optimal no. of moves required.
        trys = 0

        # checking for until we reach a floor greater than or equal to given in the question.
        while dp[trys][K] < N:
            # trys is considered as rows in dp matrix, once the floor required reaches return the optimal trys.
            trys += 1

            for egg in range(1, K + 1):
                # to calculate current dp matrix value, check for before try same eggs and one less and add both plus one more floor for current one. So that we can consider breaks and doesnt break both condition.
                dp[trys][egg] = 1 + dp[trys - 1][egg - 1] + dp[trys - 1][egg]

        return trys