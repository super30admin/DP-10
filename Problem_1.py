'''
887 Super Egg Drop
https://leetcode.com/problems/super-egg-drop/

You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.

You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than f will break, and any egg dropped at or below floor f will not break.

Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n). If the egg breaks, you can no longer use it. However, if the egg does not break, you may reuse it in future moves.

Return the minimum number of moves that you need to determine with certainty what the value of f is.

Example 1:
Input: k = 1, n = 2
Output: 2
Explanation:
Drop the egg from floor 1. If it breaks, we know that f = 0.
Otherwise, drop the egg from floor 2. If it breaks, we know that f = 1.
If it does not break, then we know f = 2.
Hence, we need at minimum 2 moves to determine with certainty what the value of f is.

Example 2:
Input: k = 2, n = 6
Output: 3

Example 3:
Input: k = 3, n = 14
Output: 4

Example 4:
Input: k = 2 eggs, n = 36 floors
Output: 8
Explanation: In all the situations, 8 minimum moves are required to find the maximum floor. Following is the strategy to do so:
Step 1: Drop from floor 8 → If breaks, check 1-7 sequentially from lower to higher.
Step 2: Drop from floor 15 (8+7) → If breaks, check 9-14.
Step 3: Drop from floor 21 (15+6) → If breaks, check 16-20.
Step 4: Drop from floor 26 (21+5) → If breaks, check 22-25.
Step 5: Drop from floor 30 (26+4) → If breaks, check 27-29.
Step 6: Drop from floor 33 (30+3) → If breaks, check 31-32.
Step 7: Drop from floor 35 (33+2) → If breaks, check 34.
Step 8: Drop from floor 36 (35+1) → Final check.

At each step:
- If the egg breaks, use the 2nd egg to check the floors linearly between the previous drop and current drop, one by one.
- If the egg doesn't break, move to the next floor in the sequence.

Let's say the critical floor f = 27:
- Drop 1: Floor 8 → survives
- Drop 2: Floor 15 → survives
- Drop 3: Floor 21 → survives
- Drop 4: Floor 26 → survives
- Drop 5: Floor 30 → breaks
Now use second egg to check:
- Floor 27 → survives
- Floor 28 → breaks
So the critical floor is 27, and total drops = 7.

Constraints:
1 <= k <= 100
1 <= n <= 10^4

Solution:
1. Recursion
We try dropping the egg from every floor and check the worst-case in both break and no-break scenarios. For each floor, we calculate max trials needed if egg breaks or doesn't, and take the minimum among all floors.
We're storing results in a memo table so we don't repeat the same work again.
Time: O(2^N), Space: O(N)

2. Tabulation 1 (bottom-up approach)
Init a dp matrix, with (k+1) rows and (n+1) columns, with all 0s. Rows contain eggs, columns contain floors.
dp[i][j] = min attempts we need to discover f with certainty using only i eggs over j floors.
Let's work out dp[2][3] as an example.
dp[2][3] = min(attempts after dropping an egg out of 2 eggs from floor 1,
               attempts after dropping an egg out of 2 eggs from floor 2,
               attempts after dropping an egg out of 2 eggs from floor 3
            )

Consider 'attempts reqd after dropping an egg out of 2 eggs from floor 2'
= 1 + max(break egg, no break)
= 1 + max( min_attempts(eggs = 1, #floors < floor 2), (eggs=1 since 1 egg broke)
           min_attempts(eggs = 2, #floors > floor 2)) (eggs=2 since 0 egg broke)
= 1 + max( dp[1][ |f < 2| ], dp[2][ |f > 2|]
= 1 + max( dp[1][1], dp[2][1])

Note:
egg break: if the egg breaks at floor 2, we know for sure that dropping an egg from any floor above floor 2 will break the egg. But we don't know for sure which floor below floor 2 will not break the egg. Hence, we should explore all floors below floor 2.

egg doesn't break: if the egg doesn't break at floor 2, we know for sure that dropping an egg from any floor below floor 2 will not break the egg. But we don't know for sure which floor above floor 2 will break the egg. Hence, we should explore all floors above floor 2.

Thus,
dp[2][3] = min(1 + max(dp[1][0], dp[2][2]),
               1 + max(dp[1][1], dp[2][1]),
               1 + max(dp[1][2], dp[2][0])
              )


https://youtu.be/hzfLNz3ZLug?t=616 (Start of dp1)
https://youtu.be/hzfLNz3ZLug?t=893 (logic of filling dp[i][j])
https://youtu.be/hzfLNz3ZLug?t=1459 (filling dp cell using 3 floors)
https://youtu.be/hzfLNz3ZLug?t=1856 (filling dp cell using 4 floors)
Time: O(K N^2), Space: O(NK)

Even though it is DP, the execution ends up in Time Limit Exceeded!

3. Tabulation 2 (bottom-up approach)
Init a dp matrix, with (n+1) rows and (k+1) columns, with all 0s. Rows contain no. of attempts, columns contain eggs. Note that the max no. of attempts with n floors = n
dp[i][j] = max no. of floors we can explore using i attempts (egg drops) while having only j eggs.
https://youtu.be/hzfLNz3ZLug?t=3942 (start of dp2)
https://youtu.be/hzfLNz3ZLug?t=4114 (filling dp[2][1])
https://youtu.be/hzfLNz3ZLug?t=4365 (filling dp[2][3])
https://youtu.be/hzfLNz3ZLug?t=4812 (stopping criterion)
Time: O(NK), Space: O(NK)
'''
from typing import List

def superEggDrop(k: int, n: int) -> int:
    def recurse(k: int, n: int) -> int:
        if n == 0:
            return 0
        if k == 1:
            return n
        if memo[k][n] != 0:
            return memo[k][n]

        min_val = float('inf')
        for f in range(1, n + 1):
            breaks = recurse(k - 1, f - 1)
            noBreak = recurse(k, n - f)
            worstCase = 1 + max(breaks, noBreak)
            min_val = min(min_val, worstCase)

        memo[k][n] = min_val
        return min_val

    memo = [[0] * (n + 1) for _ in range(k + 1)]
    return recurse(k, n)

def superEggDrop_dp1(k: int, n: int) -> int:
    dp = [[0]*(n+1) for _ in range(k+1)]
    for j in range(1,n+1):
        dp[1][j] = j

    for i in range(2,k+1): # O(k)
        for j in range(1,n+1): # O(n)
            m = float('inf')
            for f in range(1,j+1): # O(n)
                # drop egg from floor f, 1 <= f <= j
                # dropping the egg = 1 attempt
                # possible outcomes = egg breaks | egg doesn't break
                # remaining #eggs =    i - 1  |   i
                # remaining floors to explore = 1...f-1 | f+1...j
                # remaining #floors to explore = f-1+1-1 | j - (f+1) -1
                egg_brk = dp[i-1][f-1]
                egg_no_brk = dp[i][j-f]
                attempts = 1 + max(egg_brk, egg_no_brk)
                m = min(m, attempts)
            dp[i][j] = m
    return dp[k][n]

def superEggDrop_dp2(k: int, n: int) -> int:
    dp = [[0]*(k+1) for _ in range(n+1)]
    # With 0 eggs, we cannot any floors. Hence, column 0 is all 0s.

    # With 1 attempt, the max we could explore is 1 floor if we have 1 or more eggs.
    for j in range(1,k+1):
        dp[1][j] = 1

    i = 2 # i = no. of attempts
    while True:
        for j in range(1, k+1):
            egg_brk = dp[i-1][j-1]
            egg_no_brk = dp[i-1][j]
            dp[i][j] = 1 + egg_brk + egg_no_brk
        if dp[i][k] >= n or i == n:
            break
        i += 1
    return i # we return the attempts (row index) not the cell value (no. floors)

def run_superEggDrop():
    tests = [(3,4,3), (2,6,3), (3,14,4), (1,36,36), (2,36,8)]
    for test in tests:
        k, n, ans = test[0], test[1], test[2]
        print(f"\n#eggs = {k}")
        print(f"#floors = {n}")
        for method in ['recursion', 'dp1', 'dp2']:
            if method == 'recursion':
                min_attempts = superEggDrop(k,n)
            if method == 'dp1':
                min_attempts = superEggDrop_dp1(k,n)
            elif method == 'dp2':
                min_attempts = superEggDrop_dp2(k,n)
            print(f"Method {method}: Min attempts = {min_attempts}")
            success = (ans == min_attempts)
            print(f"Pass: {success}")
            if not success:
                print(f"Failed")
                return

run_superEggDrop()
