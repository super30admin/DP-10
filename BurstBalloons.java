// Time Complexity : O(n^3)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class BurstBalloons {
    public int maxCoins(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n][n];

        for(int le = 1; le<=n; le++){  // length of the burst array

            for(int i=0; i<=n-le; i++){   // start index of the burst array
                int j = i+le-1;  // end index of the burst array

                // now go over elements in the burst array
                for(int k=i; k<=j; k++){

                    // if k bursts at last then value before bursts at last
                    int leftValue = 0;

                    // if k bursts at last then value after bursts at last
                    int rightValue = 0;

                    if(i!=k){
                        leftValue = dp[i][k-1];
                    }
                    if(j!= k){
                        rightValue = dp[k+1][j];
                    }

                    //  Itself value = before Element * current element * after Element
                    int beforeEl = 1;
                    int afterEl = 1;

                    if(i!=0){
                        beforeEl = nums[i-1];
                    }
                    if(j != n-1){
                        afterEl = nums[j+1];
                    }
                    int currEl = nums[k];

                    int itselfValue = beforeEl * currEl * afterEl;

                    // leftValue + itself value + rightValue

                    dp[i][j] = Math.max(dp[i][j], (leftValue + itselfValue + rightValue));
                }
            }
        }
        return dp[0][n-1];
    }
}
