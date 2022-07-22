'''
Time Complexity: 0(n*k)
                n: number of attempts
                k: no of eggs
Space Complexity: 0(n*k)
Approach:
    Invert the problem:
    Let say I have certain no. of eggs and certain no. of attempts, how many floors you can
    cover with it
'''
class Solution:
    def superEggDrop(self, K: int, N: int) -> int:
        
        # 1. base case and initialization
        moves = [[0 for eggs in range(K + 1)] for attempts in range(N + 1)]

        for attempt in range(1, N + 1):
            for eggs in range(1, K + 1):
                #   equation to find max floors than can be checked
                moves[attempt][eggs] = 1 + moves[attempt - 1][eggs] + moves[attempt - 1][eggs - 1]

                #   return whenever it crosses more than N
                if moves[attempt][eggs] >= N:
                    return attempt