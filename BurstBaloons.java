// TC = O(n^3), SC = O(n^2)
class Solution {
    public int maxCoins(int[] nums) {

        int n = nums.length;
        int dp[][] = new int[n][n];
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                // i is the start index of the burstible array
                int j = i + l - 1; //end index of the burstible array
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) { //iterate over the burstible array
                    
                    //'left' is initially 0. If k is i then 'left' will
                    //stay 0 otherwise it gets value dp[i][k-1]
                    //'right' is similarly 0 initially. if k is j then 'right' will
                    //stay 0 other will get value dp[k+1][j]
                    int left = 0;
                    int right = 0;
                    if (i < k) {
                        left = dp[i][k-1];
                    }

                    if (j > k) {
                        right = dp[k+1][j];
                    }

                    //before and after is initially 1. If there is element on
                    //before or after of k then before/after value will take that value.
                    int before = 1;
                    int after = 1;
                    if (i > 0) {
                        before = nums[i-1];
                    }
                    if (j < n-1) {
                        after = nums[j+1];
                    }
                    // calculating the optimal(max) value from values corresponding to each elements in the burstible array
                    max = Math.max(left + (before * nums[k] * after) + right,
                            max);

                }
                dp[i][j] = max; 
            }
        }
        return dp[0][n-1];
    }


    /**

     * Recursive solution.

     */

    public int maxCoinsRec(int nums[]) {

        int[] nums1 = new int[nums.length + 2];

        nums1[0] = 1;

        nums1[nums1.length - 1] = 1;

        for (int i = 0; i < nums.length; i++) {

            nums1[i+1] = nums[i];

        }

        return maxCoinsRecUtil(nums1);

    }


    private int maxCoinsRecUtil(int[] nums) {

        if (nums.length == 2) {

            return 0;

        }


        int max = 0;

        for (int i = 1; i < nums.length - 1; i++) {

            int val = nums[i - 1]*nums[i]*nums[i+1] + maxCoinsRecUtil(formNewArray(nums, i));

            if (val > max) {

                max = val;

            }

         }

        return max;


    }


    private int[] formNewArray(int[] input, int doNotIncludeIndex) {

        int[] newArray = new int[input.length - 1];

        int index = 0;

        for (int i = 0; i < input.length; i++) {

            if (i == doNotIncludeIndex) {

                continue;

            }

            newArray[index++] = input[i];

        }

        return newArray;

    }
}