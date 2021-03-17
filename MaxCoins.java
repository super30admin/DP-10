// Time Complexity : The time complexity is O(n3) where n is the length of the array
// Space Complexity : The space complexity is O(n2) where n is the length of the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {

    public int maxCoins(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        int n = nums.length;

        int[][] dp = new int[n][n];

        //different combinations of lengths
        for(int len=1;len<=n;len++){
            //start index
            for(int i=0;i<=n-len;i++){
                //end index
                int j = i+len-1;
                //this element is deleted at the end
                for(int k=i;k<=j;k++){
                    int left = 1;
                    int right = 1;
                    if(i != 0){
                        left = nums[i-1];
                    }
                    if(j != n-1){
                        right = nums[j+1];
                    }

                    int before = 0;
                    int after = 0;
                    if(k != i){
                        before = dp[i][k-1];
                    }
                    if(k != j){
                        after = dp[k+1][j];
                    }

                    dp[i][j] = Math.max(dp[i][j],before + left*nums[k]*right + after);
                }
            }
        }
        return dp[0][n-1];
    }
}
