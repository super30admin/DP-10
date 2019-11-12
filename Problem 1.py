# Time Complexity: O(KN)
# space complexity: O(KN)
class Solution:
    def superEggDrop(self, K: int, N: int) -> int:
        # here we will see the number of tries and the eggs available
        # for a given number of tries, when the floors that can be covered exceeds the required number, that is the answer

        # created array for [number of tries][eggs] and eachentry will tell the number of floors that can be reached used the row number of tries and column number of eggs
        flr_covered = [[0 for i in range(K + 1)] for j in range(N + 1)]
        tries = 0

        # while using K number number eggs, the number of floors that can be reached is less than N
        while (flr_covered[tries][K] < N):
            tries += 1
            # using the "eggs" number of eggs and the "tries" numbe of tries
            for eggs in range(1, K + 1):
                # floors reached is 1 floor + floors that can be reached by 1 less try by breaking egg and by not breaking the egg
                flr_covered[tries][eggs] = 1 + flr_covered[tries - 1][eggs - 1] + flr_covered[tries - 1][eggs]
        return tries
