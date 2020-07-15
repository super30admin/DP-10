//Time Complexity: O(n^3) -> n: to calculate left; n: to calculate right, n: to iterate over the array
//Space Complexity: O(n^2) -> dp matrix formed is the only space consumed

public class Solution{
    public int maxCoins(int[] nums) {
        //base case
        if(nums == null || nums.length == 0){
            return 0;
        }
        //store length of the nums array
        int n = nums.length;
        //dp of n*n size 
        int[][] dp = new int[n][n];
        //from subarray of length 1 to array size
        for(int len = 1; len <= n; len++ ){
            //i: starting location of the subarray
            for(int i=0; i <= n-len; i++){
                //j: ending location of the subarray considered
                int j = i + len - 1;
                //k: the location at which we are assuming the balloon is bursting 
                //...i....k....j -> where 'k' goes from i->j
                for(int k=i; k<=j; k++){
                    //leftval and rightval are the elements beside kth element
                    int leftVal = 1;
                    int rightVal = 1;
                    //if i=0, leftval is 1
                    //else the prev element is considered
                    if(i != 0){
                        leftVal = nums[i-1];
                    }
                    //if j=n-1, rightVal is 1
                    //else the element of the given nums array
                    if(j != n-1){
                        rightVal = nums[j+1];
                    }
                    //before and after are values if calculated before from the dp matrix
                    int before = 0;
                    int after = 0;
                    //getting the location from the dp matrix
                    if(i != k){
                        before = dp[i][k-1];
                    }
                    if(j != k){
                        after = dp[k+1][j];
                    }
                    //max of curr dp vaue and before + after + left*val*right values
                    dp[i][j] = Math.max(before + leftVal * nums[k] * rightVal + after, dp[i][j]);
                }
            }
        }
        //last index of the 0th row is the output
        return dp[0][n-1];    
    }
}