'''
Solution:
1.  Semi optimal soultion using DP would be for N floors and K eggs, where you consider one of two options when egg is
    dropped from ith floor, either egg is broken or not broken.
    If broken => consider the cell [K-1, i-1] meaning try K-1 eggs for i-1 below floors
    If non broken => consider cell [K, N-i] meaning try K eggd in any of the above N-i floors
    As 1 move is completed => 1 + max(broken, non-broken) => 1 + max(cell[K-1, i-1], cell[K, N-i]) for cell[K, N]

2.  The previous solution is O(K*N*N) and so consider the problem in a different way, given K eggs and M moves, what is
    the max floor that can be checked with given conditions. There are two cases here as well, after a move, egg breaks
    or doesn't break => m-1 moves and k-1 eggs if broken, k eggs if non-broken
    cell[m, k] = 1 + cell[m-1, k-1] + cell[m-1, k] meaning after 1 move, egg breaks OR non-breaks

Time Complexity:    O(K*N)
Space Complexity:   O(K*N) for solution 1 and O(N) for solution 2

--- Passed all testcases successfully on leetcode for both the solutions.

'''


class SuperEggDropI:
    def superEggDrop(self, K: int, N: int) -> int:

        #   base case and initialization
        moves = [[0 for eggs in range(K + 1)] for attempts in range(N + 1)]

        for attempt in range(1, N + 1):
            for eggs in range(1, K + 1):
                #   equation to find max floors than can be checked
                moves[attempt][eggs] = 1 + moves[attempt - 1][eggs] + moves[attempt - 1][eggs - 1]

                #   return whenever it crosses more than N
                if moves[attempt][eggs] >= N:
                    return attempt

        return N

class SuperEggDropII:
    def superEggDrop(self, K: int, N: int) -> int:

        #   base case and initialization
        previousAttempts = [0 for eggs in range(K + 1)]

        for attempt in range(1, N + 1):
            currentAttempts = [0]

            for eggs in range(1, K + 1):

                #   equation to find max floors than can be checked
                currentAttempts.append(1 + previousAttempts[eggs] + previousAttempts[eggs - 1])

                #   return whenever it crosses more than N
                if currentAttempts[eggs] >= N:
                    return attempt

            previousAttempts = currentAttempts

        return N