// Time Complexity : O(n^3)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Approach : We follow bottom up dp approach here as we found repeated subproblems. First we consider the size of burstible array that
// starts from length 1 to the size of nums array. In each burstible array, we calculate the permutations of each ballon being burst at the end
// and consider the maximum of those and place it in a dp matrix. At the end, we return the [0][n-1] that gives the result.

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int le=1; le<=n; le++){ // size of burstible array
            for(int i=0; i<= n-le; i++){ // start index of burstible array
                int j = i+le-1; //end index of burstible array
                for(int k=i; k<=j; k++){ //looping inside burstible array

                    // leftSum + balloonItself + rightSum
                    int leftSum = 0;
                    int rightSum = 0;

                    if(i != k)
                    {
                        leftSum = dp[i][k-1]; //when k is not at i
                    }
                    if(j != k){
                        rightSum = dp[k+1][j]; //when k is not at j
                    }
                    int leftne = 1;
                    int rightne = 1;
                    if(i > 0){
                        leftne = nums[i-1]; //left neighbors of current burstible array
                    }
                    if(j < n-1){
                        rightne = nums[j+1]; //rigth neighbors of current burstible array
                    }
                    int balloonItself = leftne * nums[k] * rightne; // sum at ballon itself that is popped at end

                    dp[i][j] = Math.max(dp[i][j], leftSum + balloonItself + rightSum);

                }
            }

        }
        return dp[0][n-1];
    }
}
