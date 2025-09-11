'''
312 Burst Balloons
https://leetcode.com/problems/burst-balloons/description/

You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

1. Brute Force
For N baloons, there are N! ways to burst the baloons.

Assume the balloons are indexed as follows:
0 ... i-1  [i ... j]  j+1 ... N-1
Let burstable array: [i...j] (index of burstable array = k, hence i<=k<=j)

We recursively try every balloon to burst last in the current burstable subarray.
For each balloon indexed k in the burstable subarray [i,...,j], we calculate the max profit obtained from bursting balloon k at the last (among [i...j]) and solving the left burstable subarray ([i,...,k-1] and right burstable subarray ([k+1,...,j]). The left and right burstable subarrays are subproblems that have no dependency on each other. They are only dependent on balloon k since it is the last balloon to burst. The best result from all possible last balloons gives the maximum coins.

Thus,
f(i,j):
    max_profit = 0
    for k in range(i,j+1):
        profit = burst k + f(i,k-1) + f(k+1,j)
        max_profit = max(profit, max_profit)
    return max_profit

We start the recursion by calling f() using the entire array, i.e., f(0,N-1).
https://youtu.be/Q_TlN_EGG7A?t=568
Important point: https://youtu.be/Q_TlN_EGG7A?t=718  (index skipped higher up in the tree doesn't mean it is skipped in the lower part of the tree)
https://youtu.be/Yz4LlDSlkns?t=1258 (explains how sub-problems are independent)
Time: O(N^N), Space: O(N)

2. Tabulation (bottom-up)
Assume the balloons are indexed as follows:
0 ... i-1  [i ... j]  j+1 ... N-1
Let burstable array: [i...j] (index of burstable array = k, hence i<=k<=j)

Define dp[i][j] = max profit obtained  by bursting the sub-group of balloons (indexed i...j) given that the sub-group is surrounded on the left and right
left = 0...i-1
right = j+1...N-1

sub-problem = max profit obtained by bursting the balloons
in the burstable array (in some order which yields max profit)
= dp[i][j]
= burst balloon k within the burstable array at the last +
  burst baloons i...k-1 +
  burst balloons k+1...j

It is important to note that the sub-problem is not about bursting baloons i..j in isolation. It is about bursting balloons i..j in the context of all the balloons available in its left and right of sub-group i...j

https://youtu.be/Q_TlN_EGG7A?t=894
https://youtu.be/YzvF8CqPafI?t=179 (good illustrative example)
https://youtu.be/YzvF8CqPafI?t=944 (important point: context of sub-problem)
https://youtu.be/YzvF8CqPafI?t=1209 (sample dry run to get dp[i][j])
https://www.youtube.com/watch?v=zfgZtcDQAxw (code)

Time: O(N^3), Space: O(N^2)

'''
from typing import List

def maxCoins(nums: List[int]) -> int:
    def recurse(nums, i, j):
        if i > j:
            return 0

        m = 0
        for k in range(i,j+1):
            # k is the last balloon to burst in the window of balloons [i,...,j]
            this = (1 if i == 0 else nums[i-1]) * \
                       nums[k] * \
                       (1 if j == N-1 else nums[j+1])

            # optimize the left window [i,.,k-1]
            left  = recurse(nums,i,k-1)

            # optimize the right window [k+1,.,j]
            right = recurse(nums,k+1,j)

            m = max(m, this + left + right)
        return m

    if not nums:
        return 0
    N = len(nums)
    m = recurse(nums, 0, N-1)
    return m

def maxCoins_dp(nums: List[int]) -> int:
    if not nums:
        return 0
    N = len(nums)
    dp = [[0]*N for _ in range(N)]
    for l in range(1,N+1):
        for i in range(N):
            j = l+i-1
            if j > N - 1:
                continue
            for k in range(i,j+1):
                # profit by bursting balloon k at the last, where i<=k<=j
                this = (1 if i == 0 else nums[i-1]) * \
                       nums[k] * \
                       (1 if j == N-1 else nums[j+1])

                # profit by bursting balloons i to k-1
                left = 0 if k == i else dp[i][k-1]

                # profit by bursting k+1 to j
                right = 0 if k == j else dp[k+1][j]

                dp[i][j] = max( dp[i][j], left + this + right)
    #print(dp)
    return dp[0][N-1]


def run_maxCoins():
    tests = [([3,1,5,8],167), ([1,5],10), ([2,3,1,5,6,4],231)]
    for test in tests:
        nums, ans = test[0], test[1]
        print(f"\nnums = {nums}")
        for method in ['recurse', 'dp']:
            if method == 'recurse':
                profit = maxCoins(nums)
            elif method == 'dp':
                profit = maxCoins_dp(nums)
            print(f"Method {method}: profit = {profit}")
            success = (ans == profit)
            print(f"Pass: {success}")
            if not success:
                print(f"Failed")
                return

run_maxCoins()