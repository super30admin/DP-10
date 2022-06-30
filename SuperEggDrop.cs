// Time Complexity :O(kn^2)
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// 1) Exhaustive or DP approach
// 2) Array of n floors columns and k eggs as rows
//     a. Calculate moves for every combination and put in grid
//     b. 1 egg for 2 floors
//         i. Egg might break at floor 1 or might break at floor 2 or might not break t floor 2 also
//         ii. So total moves max is 2
//         iii. Same way we will calculate moves for other combinations like that.
//     c. For rest of cells, we need to take min of cases break or no break and add 1
//     d. Dp[i][j] - i is number of eggs remaining and j is numbers of rows remaining
//         i. Breaks - explore rows belor
//         ii. No break - explore rows above, because if doesn’t break, we need to be looking above floors not floors below.

public int SuperEggDrop(int k, int n) {
    if(n == 0 || k == 0)
        return 0;
    
    int[,] dp = new int[n+1, k+1];
    int attempts = 0;
    
    while(dp[attempts, k] < n)
    {
        attempts++;
        for(int j = 1; j <= k; j++)
        {
            dp[attempts, j] = 1 + dp[attempts -1, j-1] + dp[attempts-1, j];
        }
    }
    
    return attempts;
}

private int SuperEggDropDPBruteForce(int k, int n)
{
    int[,] dp = new int[k+1, n+1];
    for(int j = 1; j <= n; j++)
    {
        dp[1,j] = j;
    }
    
    for(int i = 2; i <= k; i++)
    {
        for(int j = 1; j <= n; j++)
        {
            //we take min value at next staement, by default initialzation is 0, then it will be 0 always
            dp[i,j] = Int32.MaxValue;
            for(int f = 1; f <= j; f++)
            {
                //two cases egg break and no break
                dp[i,j] = Math.Min(dp[i,j], 1 + Math.Max(dp[i-1, f-1], dp[i, j-f]));
            }
        }
    }
    
    return dp[k,n];
}