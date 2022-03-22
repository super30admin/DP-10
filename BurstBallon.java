// Time Complexity : O(n^2)
// Space Complexity : O(n^3)
// Did this code successfully run on Leetcode : Yes

public class BurstBallon {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[][] dp = new int[n][n];

        //take burstable sub arrays of len 1 to n
        for(int len = 1; len <= n; len++){
            //start index depends on curr len of burstable array
            //i.e when len = 2, start indices are 0,1,2 and when len = 3, it is 0,1
            for(int start = 0; start <= n - len; start++){
                int end = start + len -1;
                //k - index of balloon that is getting bursted at the end
                // before + (left *curr * right) + after
                //before - already bursted balloons on left of curr ballon
                //before - already bursted balloons on right of curr ballon
                //left - left non bursted balloon in main array
                //right - right non bursted balloon in main array
                for(int k = start; k <= end; k++){

                    int before = 0;
                    int after = 0;
                    if(k != start){ //not leftmost ballon
                        before = dp[start][k-1];
                    }
                    if(k != end){ //not rightmost ballon
                        after = dp[k+1][end];
                    }

                    int left = 1;
                    int right = 1;

                    if(start != 0){
                        left = nums[start - 1];
                    }
                    if(end != n - 1){
                        right = nums[end + 1];
                    }

                    dp[start][end] = Math.max(dp[start][end],
                            before + (left * nums[k] * right) + after);
                }
            }
        }
        return dp[0][n-1];
    }
}
