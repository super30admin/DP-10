// Burst Balloon (https://leetcode.com/problems/burst-balloons/)

// Time Complexity :O(n^3)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {number[]} nums
 * @return {number}
 */
var maxCoins = function (nums) {
    if (nums === null || nums.length === 0)
        return 0;

    let n = nums.length;
    let dp = new Array(n);
    for (let i = 0; i < n; i++) {
        dp[i] = new Array(n);
        dp[i].fill(0);
    }
    for (let len = 1; len <= n; len++) {
        // Iterate all combinations for each length 
        // i is the starting index of burstable balloon array
        for (let i = 0; i <= n - len; i++) {
            // j is the ending index of burstable balloon array
            let j = i + len - 1;
            // k is the index of balloon which will be burst last
            for (let k = i; k <= j; k++) {
                let leftCoins = 0;
                if (k > i) {
                    leftCoins = dp[i][k - 1];
                }
                let rightCoins = 0;
                if (k < j) {
                    rightCoins = dp[k + 1][j];
                }
                let left = 1;
                if (i > 0) {
                    left = nums[i - 1];
                }
                let right = 1;
                if (j < n - 1) {
                    right = nums[j + 1];
                }
                let prod = left * nums[k] * right;
                dp[i][j] = Math.max(dp[i][j], leftCoins + prod + rightCoins);
            }
        }
    }
    console.log(dp)
    return dp[0][n - 1];
};