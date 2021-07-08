// Time Complexity : O(N^3)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, this is a hard problem

var maxCoins = function(nums) {
    if (!nums || !nums.length) return 0;
    
    const n = nums.length;
    const gain = new Array(n);
    for (let i = 0; i < gain.length; i++) {
        gain[i] = new Array(n).fill(0);
    }
    
    for (let len = 1; len <= n; len++) {
        for (let i = 0; i <= n - len; i++) {
            // Size of our current range
            let j = len + i - 1;
            
            for (let k = i; k <= j; k++) {
                const leftGain = k != i ? gain[i][k - 1] : 0,
                      rightGain = k != j ? gain[k + 1][j] : 0,
                      leftVal = i > 0 ? nums[i - 1] : 1,
                      rightVal = j < n - 1 ? nums[j + 1] : 1;
                const currGain = leftGain + leftVal * nums[k] * rightVal + rightGain;
                gain[i][j] = Math.max(gain[i][j], currGain);
            }
        }
    }
    
    return gain[0][n - 1]
};
