class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0; //if nums array is null or the length of nums array is 0, return 0
        int n = nums.length; //n stores the length of nums
        int[][] dp = new int[n][n]; //we initialize a 2d array of size n and n.
        for(int len = 1; len <= n; len++) { //this is the outer loop which start from 1 until the length of the array
            //starting index of bursting balloons
            for(int i = 0; i <= n - len; i++) { //going through the elements until n - len
                //ending index of bursting balloons
                int j = i + len - 1; //computing the value of j
                for(int k = i; k <= j; k++) { //going through all the elements starting from i until j
                    int before = 0, after = 0; //initializing before and after to 0
                    if(k != i) { //if k is not equal to i
                        before = dp[i][k - 1]; //compute before
                    }
                    if(k != j) { //if k is not equal to j
                        after = dp[k + 1][j]; //compute after
                    }
                    int left = 1, right = 1;//initialize left and right variables
                    if(i != 0) { //if i not equal to 0
                        left = nums[i - 1]; //compute left
                    }
                    if(j != n - 1) { //if i not equal to n - 1
                        right = nums[j + 1]; //compute right
                    }
                    dp[i][j] = Math.max(dp[i][j], before + left * nums[k] * right + after); //compute the value at i and j
                }
            }
        }
        return dp[0][n - 1]; //in the end return the value at the first row and the last col.
    }
}
//tc and sc - O(n ^ 3) and O(n ^ 2)