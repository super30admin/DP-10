// Time Complexity : O(n3)
// Space Complexity :O(n2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if(nums==null || n== 0) return 0;
        int[][] dp = new int[n][n];
        for(int l=1; l<=n;l++){  // loop through length n
            // form subarrays i
            for (int i=0; i<=n-l;i++){ //n  //i-start index of subarry the start indexes can be from 0 to l-n
                int j = i+l-1; // end index of sub array
                for(int k =i;k<=j;k++)//n// In the subarray find the max coins from every baloon(ele) bursting at the end.
                {
                    int curr = nums[k]; // every element in the subarray at a single time
                    int left=1; // 1 to multiply
                    int right =1; // 1 to multiply
                    if(i!=0){     // because u cant have left most when index is 0
                        left= nums[i-1];
                    }
                    if(j!=n-1){
                        right = nums[j+1]; // because u cant have right most when index is 0
                    }
                    int before =0; // the no.of baloons that were burst before(left) curr ele's in the subarray
                    int after =0;  // the no.of baloons that were burst after curr(right) ele's in the subarray
                    // consider non bursted balloon from the main array from left
                    if(k!=i) before = dp[i][k-1];   // ignore left element when k and i are same because there wont be any left elements in subarray.
                    // consider non bursted balloon from the main array towards right
                    if(k!=j) after = dp[k+1][j]; // ignore right element when k and j are same because there wont be any right elements in subarray.
                    dp[i][j] = Math.max(dp[i][j], before+left*curr*right+after); // store the max
                }
            }
        }
        return dp[0][n-1];
    }
}