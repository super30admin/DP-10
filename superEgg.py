"""
Let dp[m][k] = maximum number of floors we can check with k eggs and m moves
Recurrence:
dp[m][k] = dp[m-1][k-1] + dp[m-1][k] + 1
One move: Egg breaks - dp[m-1][k-1]  Egg doesn't break - dp[m-1][k]
Increase m until dp[m][k] ≥ n — that’s the minimum moves needed
"""
"""
Time Complexity: O(k × log n)	In practice, m grows ≈ log n
Space Complexity: O(k × log n)	2D table with m rows, k cols
"""


class superEgg:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[0] * (k + 1) for _ in range(n + 1)]

        for m in range(1, n + 1):
            for eggs in range(1, k + 1):
                dp[m][eggs] = dp[m - 1][eggs - 1] + dp[m - 1][eggs] + 1
            if dp[m][k] >= n:
                return m

if __name__ == "__main__":
    obj = superEgg()
    print(obj.superEggDrop(1, 2))     
    print(obj.superEggDrop(2, 6))   
    print(obj.superEggDrop(3, 14))  
    print(obj.superEggDrop(4, 500))
