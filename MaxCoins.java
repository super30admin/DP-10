/**

 * Interval DP solution to the Burst Balloons problem using bottom-up tabulation.

 * We try every possible balloon as the last to burst in a range and combine left + self + right subproblems.

 * Time Complexity: O(n^3), Space Complexity: O(n^2)

 */

public class MaxCoins {
        public int maxCoins(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n];

        for (int le = 1; le <= n; le++) { //size of bustable array
            for (int i = 0; i <= n - le; i++) { // start indices
                int j = i + le - 1;
                for (int k = i; k <= j; k++) { //permutation of bursting baloons
                    //before + baloonItself + after
                    int before = 0, after = 0; 

                    if(i != k) {
                        before = dp[i][k-1];
                    }
                    if(j !=k) { 
                        after = dp[k+1][j];
                    }

                    int prev = 1, next =1; 
                    if(i > 0) {
                        prev = nums[i-1];
                    }

                    if( j < n-1) {
                        next = nums[j+1];
                    }
                    int baloonItself = prev * nums[k] * next;

                    dp[i][j] = Math.max(dp[i][j], before + baloonItself + after);
                }
            }
        }
        return dp[0][n-1];
    }
}
    
}
