// Time Complexity : n^3
// Space Complexity : n^2
// Did this code successfully run on Leetcode : Yes

/*
Approach 1: Exhaustive - where we burst every combination of balloons and calculate the max
- exponential solution 

Approach 2: DP with permutation 
The subproblems are smallest possible burstable array 
1. single balloons 
2. 2 balloons -> we have the solution for bursting 1 balloon 
	2 permutations for bursting each balloon in the end (we have solved the bursting of other balloons already)
3. 3 balloons -> and iterate over bursting each balloon in the end
	[0,1,2] =>
	0 in the end = bust(0) + [1][2] and we have already solved [1][2] 
	1 in the end = [0] + burst(1) + [2] and we have solved [0] and [2]
	2 in the end = [0][1] + burst(2)

4. 4 balloons: [0,1,2,3]
	0 in the end = burst(0) + [1][3]
	1 in the end = [0] + burst(1) + [2][3]
	2 in the end = [0][1] + burst(2) + [3]
	3 in the end = [0][2] + burst(3) 

	to burst that balloon : at every stage we consider what is to the left and right 
	the left and right is outside the burstable array since we are bursting that balloon in the end and we have already burst what was to its left and right inside the burstable array

*/

class Solution {
public:
    int maxCoins(vector<int>& nums) {
        if(nums.size() == 0)
            return 0;

        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));

        for(int i=0; i<n; i++) {
            for(int start=0; i+start<n; start++) {
                int end = i + start;
                // iterate over the burstable array and add to the result
                for(int currBurst = start; currBurst <= end; currBurst++) {
                    // result = (max of) dp[start][currBurst-1] + burst current balloon + dp[currBurst+1][end];
                    int left = 0;
                    int right = 0;
                    // in the current burstable array, if there is something to the left
                    // Ex: [0,1,2,3] and we are bursting 1, we need the solution of [0] on the left
                    if(currBurst != start)
                        left = dp[start][currBurst-1];

                    // we need the solution [2,3] to the right
                    if(currBurst != end)
                        right = dp[currBurst+1][end];
                    
                    // now bursting [1] = whatever balloon is remaining on the left * curr * right
                    int mid = 1;

                    if(start != 0)
                        mid *= nums[start-1];
                    if(end != n-1)
                        mid *= nums[end + 1];
                    mid *= nums[currBurst];

                    // we need the max solution
                    dp[start][end] = max(dp[start][end], left + mid + right);
                }
            }
        }
        return dp[0][n-1];
    }
};