// Time Complexity : O(K*N) but it has some early stopping power, and will never take the full N as a factor
// Space Complexity : O(K*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, this is a hard problem.  It was hard to wrap my head around the reverse process of
// mapping attempts and eggs to max floors

const superEggDrop = (K, N) => {
    const dp = new Array(N + 1);
    for (let i = 0; i < dp.length; i++) {
         dp[i] = new Array(K + 1).fill(0);
    }
    
    for (let attempt = 1; attempt <= N; attempt++) {
        for (let egg = 1; egg <= K; egg++) {
            dp[attempt][egg] = 1 + dp[attempt - 1][egg - 1] + dp[attempt - 1][egg];
            if (dp[attempt][egg] >= N) return attempt;
        }
    }
};
