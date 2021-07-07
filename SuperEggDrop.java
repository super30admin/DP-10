package com.example.problems;

//Time Complexity : O(N^3) for First Approach,O(N^2) for Second Approach 

//Space Complexity : O(N^2) for All Approaches
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach

/*
Approach 1 
This problem asks us to find minimum floor from which egg will be  safe to drop.
When we drop an egg from a floor x, there can be two cases (1) The egg breaks (2) The egg doesn’t break.

1) If the egg breaks after dropping from xth floor, then we only need to check for floors lower than x with remaining eggs; so the problem reduces to x-1 floors and n-1 eggs
2) If the egg doesn’t break after dropping from the xth floor, then we only need to check for floors higher than x; so the problem reduces to k-x floors and n eggs.

Since we need to minimize the number of trials in worst case, we take the maximum of two cases. We consider the max of above two cases for every floor and choose the floor which yields minimum number of trials.
So Total Time Complexity is O(N^3) 

Approach 2

The above approach works fine for smaller numbers but might not work on larger numbers.
It explores all N floors for K Eggs.Let reverse the situation.So we will explore K eggs for N floors.
In this case we use following mathematical approach . 
        f(T,K)= 1+ f(T−1,K−1) + f(T−1,K)

The approaches remains the same.Now we are finding how many eggs are breaking from K floors
Total Number of Attempts REquired= 1 + Egg Break from N(we explore K - 1 eggs from N -1 floors) + Egg does not break(We explore K eggs from upper floors)

*/
public class SuperEggDrop {

	public int superEggDrop1(int K, int N) {
		int dp[][] = new int[K + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			dp[1][i] = i;
		}

		int res = 0;
		for (int egg = 2; egg <= K; egg++) {
			for (int floor = 1; floor <= N; floor++) {
				dp[egg][floor] = Integer.MAX_VALUE;
				for (int k = 1; k <= floor; k++) {
					int eggBreak = dp[egg - 1][k - 1];
					int noEggBreak = dp[egg][floor - k];
					res = 1 + Math.max(eggBreak, noEggBreak);
					if (res < dp[egg][floor]) {
						dp[egg][floor] = res;
					}
				}
			}
		}
		return dp[K][N];

	}

	public int superEggDrop2(int K, int N) {
		int dp[][] = new int[N + 1][K + 1];
		int i = 0;
		while (dp[i][K] < N) {
			i++;
			for (int j = 1; j <= K; j++) {
				dp[i][j] = 1 + dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		return i;
	}

	public static void main(String args[]) {
		int K = 1, N = 2;
		SuperEggDrop eggDrop = new SuperEggDrop();
		System.out.println(eggDrop.superEggDrop1(K, N));
		System.out.println(eggDrop.superEggDrop2(K, N));
		K = 2;
		N = 6;
		System.out.println(eggDrop.superEggDrop1(K, N));
		System.out.println(eggDrop.superEggDrop2(K, N));
		K = 3;
		N = 14;
		System.out.println(eggDrop.superEggDrop1(K, N));
		System.out.println(eggDrop.superEggDrop2(K, N));

	}
}
