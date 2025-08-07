// Time Complexity : O(n^3)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : let's maintain a burstible array, initially just first element in nums and next add next element. 
/// For each length of burstible array, find all permutations - what is the max we can earn if we burst current balloon and so on
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        //for length of burstible array
        for(int le = 1; le<=n;le++){
            //for start of array
            for(int i=0;i<=n-le;i++){
                //end of array;
                int j = i+le-1;
                //all permuatations
                int max = 0;
                for(int k = i;k<=j;k++){
                    int before =0, after = 0;
                    if(i!=k){
                        before = dp[i][k-1];
                    }
                    if(j!=k){
                        after = dp[k+1][j];
                    }
                    int left = 1, right = 1;
                    if(i!=0){
                        left = nums[i-1];
                    }
                    if(j!=n-1){
                        right = nums[j+1];
                    }
                    max = Math.max(max, before + left*nums[k]*right + after);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n-1];
    }
}