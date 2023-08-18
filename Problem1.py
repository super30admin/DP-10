class Solution:
    def superEggDrop(self, K: int, N: int) -> int:
        # Time Complexity: O(K * N)
        # Space Complexity: O(K)
        dp = [0] * (K + 1)  # Initialize the 1D DP array

        attempts = 0  # Initialize the number of attempts

        # Iterate until the DP value for the given number of floors is less than the desired N
        while dp[K] < N:
            attempts += 1  # Increment the number of attempts
            for eggs in range(K, 0, -1):
                # Calculate the DP value for the current eggs using the recurrence relation
                dp[eggs] = 1 + dp[eggs - 1] + dp[eggs]

        return attempts
