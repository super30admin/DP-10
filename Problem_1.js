// Problem1: Super Egg Drop (https://leetcode.com/problems/super-egg-drop/)

// Time Complexity : O(kn)
// Space Complexity : O(kn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {number} k
 * @param {number} n
 * @return {number}
 */
var superEggDrop = function (k, n) {
    if (k === 0 || n === 0)
        return 0;

    // dp where rows = number of attempt(max = n), cols = available eggs(k)
    // values are the number of floors that can be explared with i attempts and j eggs
    let dp = new Array(n + 1);
    for (let i = 0; i < dp.length; i++) {
        dp[i] = new Array(k + 1);
        dp[i].fill(0);
    }

    let attempts = 0;
    while (dp[attempts][k] < n) {
        // row
        attempts++;
        // For each column
        for (let j = 1; j < k + 1; j++) {
            dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j];
        }
    }
    return attempts;
};