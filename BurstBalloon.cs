// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public int MaxCoins(int[] nums) {
    if(nums == null || nums.Length == 0)
        return 0;
    
    int n = nums.Length;
    int[,] dp = new int[n,n];
    
    //get an array of 1 to nwhen we are selecting the sub array for differenet indexes combination
    for(int len = 1; len <= n; len++)
    {
        //establish the starting index
        for(int i = 0; i <= n - len; i++)
        {
            //establish the ending index
            int j = i + len -1;
            //calculate max when bursting the given element at index
            // before + currentsum +  after
            //we need to run loop from i to j
            for(int k = i; k <= j; k++)
            {
                //if we are bursting first element in sub array, then get before element
                int before = 0;                    
                if(k != i)
                    before = dp[i, k-1];
                
                //if we are bursting last element in sub array, then get after element
                int after = 0;
                if(k != j)
                    after = dp[k+1, j];
                
                //now get sum for bursting current element
                
                //left element, also check if current element is first element
                int left = 1;
                int curr = nums[k];
                if(i != 0)
                    left = nums[i-1];
                //right element, also check if current element is last element
                int right = 1;
                if(j != n-1)
                    right = nums[j+1];
                //get max of current or calculated max by bursting
                dp[i,j] = Math.Max(dp[i,j], before + left * nums[k] * right +  after);
            }                
        }
    }
    //max lies at end of column, first row
    return dp[0, n-1];
}