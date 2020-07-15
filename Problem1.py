class Solution:
	def superEggDrop2(self, K: int, N: int) -> int:
		# Time Complexity : O(K * N^2) because in the inner loop we are iterating through each and every element of j for every element of j
		# Space Complexity : O(K * N) we are creating a dp array of that size
		# Time Limit Exceeded on Leetcode
		dp = [[0 for _ in range(N + 1)]for _ in range(K + 1)]
		for i in range(1, N + 1):
			dp[1][i] = i
		for j in range(1, K + 1):
			dp[j][1] = 1
		for i in range(2, K + 1):
			for j in range(2, N + 1):
				minVal = float('inf')
				for k in range(1, j + 1):
					minVal = min(minVal, 1 + max(dp[i - 1][k - 1], dp[i][j - k]))
				dp[i][j] = minVal
		return dp[K][N]

	def superEggDrop1(self, K: int, N: int) -> int:
		# Time Complexity : O(NK) because we are creating a dp array of that size and we are iterating throught each and every element of that dp array
		# Space Complexity : O(NK)
		# Accepted on leetcode
		dp = [[0 for _ in range(K + 1)] for _ in range(N+1)]
		floorNum = 0
		while dp[floorNum][K] < N:
			floorNum += 1
			for i in range(1, K + 1):
				dp[floorNum][i] = 1 + dp[floorNum - 1][i - 1] + dp[floorNum - 1][i]
		return floorNum