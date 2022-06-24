/*
Problem:
*/

// Approach 1: DP : TLE
// TC: O(k * n * n)
// SC: O(n * k)
class Solution {
    public int superEggDrop(int k, int n) {
        if (k == 0 || n == 0)
            return 0;
        
        // Stores number of attempts to get floor from which egg breaks
        int dp[][] = new int[k + 1][n + 1];
        
        // First row and first column is always 0

        // If we have one egg, minimum number of moves to know with certainity would be equal to floor number
        // Let's we started from floor 1 and went up to j and the egg didn't break in any of the floors.
        // In that case, minimum would be the floor number itself
        for (int j = 1; j <= n; ++j)
            dp[1][j] = j;
        
        
        for (int eggs = 2; eggs <= k; ++eggs) {
            for (int floor = 1; floor <= n; ++floor) {
                dp[eggs][floor] = Integer.MAX_VALUE;
                for (int currentFloor = 1; currentFloor <= floor; ++currentFloor) {
                    dp[eggs][floor] = Math.min(
                        dp[eggs][floor], 
                        // Case 1: break: eggs reduces by 1 and we want to check from floors below currentFloor to see if it breaks from there
                        // Case 2: not break: we still have 'eggs' number of eggs and we want to check from remaining floors above currentFloor to see if it breaks from there
                        1 + Math.max(dp[eggs - 1][currentFloor - 1], dp[eggs][floor - currentFloor])
                    );
                }
            }
        }
        
        return dp[k][n];
    }
}

// Approach 2: maintain the number of floors in the dp array
// TC: O(k * n)
// SC: O(k * n)
class Solution {
    public int superEggDrop(int k, int n) {
        if (k == 0 || n == 0)
            return 0;
        
        // Stores number of floors we need to explore with n attempts and k eggs
        int dp[][] = new int[n + 1][k + 1];
        int attempts = 0;
        
        while (dp[attempts][k] < n) {
            ++attempts;
            for (int eggs = 1; eggs <= k; ++eggs) {
                // Whenever we make an attempt, we have to reduce attempts by 1
                // If we don't break an egg, eggs remain the same
                // If we break an egg, eggs reduce by 1
                dp[attempts][eggs] = 1 + dp[attempts - 1][eggs - 1] + dp[attempts - 1][eggs];
                if (dp[attempts][eggs] > n)
                    return attempts;
            }
        }
        
        return attempts;
    }
}