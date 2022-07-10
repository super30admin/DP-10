class Solution {

    // Time Complexity : 0(n^3) where n is the no. of elements in nums
// Space Complexity : 0(n^3)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int n = nums.length;
        int [][] dp = new int [n][n];

        for(int len = 1; len <= n; len++){  //bursting balloons of len =1 first, then increase the len to 2 and so on
            //get the starting index
            for(int i = 0; i <= n-len; i++){
                //establish the last index
                int j = i + (len-1);
                //running a loop from i to as as i is the starting index nad j is the end index and then I compute bursting indivudual balloons
                for(int k = i; k <= j; k++){
                    int before = 0;
                    if(k != i){ //if the current position is not starting point
                        before = dp[i][k-1];    //getting from dp array
                    }
                    int after = 0;
                    if(k != j){ //if current position is not end point
                        after = dp[k+1][j]; //geting from dp array
                    }
                    int left = 1;
                    if(i != 0){ //if there is a value on left of the starting position, I will take that or I multiply by 1. Eg:[3,4]. 2 is there on left
                        left = nums[i-1];
                    }
                    int right = 1;
                    if(j != n - 1){ //if there is a value on right of the end position then I take that or I multiply by 1. Eg [3,4] 5 is there on right
                        right = nums[j+1];
                    }
                    dp[i][j] = Math.max(dp[i][j], before + left*nums[k]*right + after);//Doing the computation
                }
            }
        }
        return dp[0][n-1];
    }
}