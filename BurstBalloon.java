// Time Complexity : O(N^3)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for(int le=1;le <= n;le++){
            for(int i=0; i <=n-le;i++){ // start range
                int j= i+le-1;  //end range
                for(int k=i;k<=j;k++){ // bursting balloon at the last
                    // before value + balloon itself value + after alue

                    int before = 0;
                    int after = 0;

                    if(k != i){
                        before = dp[i][k-1];
                    }

                    if(k != j){
                        after = dp[k+1][j];
                    }

                    int prev = 1;
                    int next =1;
                    int curr = nums[k];

                    if( i != 0){
                        prev = nums[i-1];
                    }

                    if(j != n-1){
                        next = nums[j+1];
                    }

                    int balloonItself = prev * curr * next;

                    dp[i][j] = Math.max(dp[i][j],before+balloonItself+after);
                }
            }
        }

        return dp[0][n-1];
    }
}