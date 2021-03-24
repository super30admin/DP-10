//Time Complexity: o(n^3)
//Space Complexity: o(n * n) n is the length of the input array
//Expln: We keep going from bottom up manner first we burst 1 balloon then 2 then 3 so on up to the length of the array.
//So we create a dp matrix indicating the index until we burst say [3][3] we only burst balloon 3 and store the result in that location
//So from next time if we have to find whats the best soln if we burst from [3][3] we can get it from dp array.
// Similar example we are bursting from [1][3] assume so we store it in the corresponding dp array. 
// Also its interesting how we find [1][3] we traverse independent ballon say 1 what is the result if we burst 1 (in the last)since we 
// already computed for [2][3] we can directly use it and the left and right balloon is nums[0] and nums[4] if exists because all the other
// balloons are already bursted only the index after the array we are computing is left and right and before and after values are
// what are the best possible values if we burst [2][3] is already computed and since in [1][3] we are bursting 1 before is 0, but 
// since we are bursting this last left and right exists i.e after the boundary[1][3] in this way we compute for [2] and [3] what is the
// best result if we burst last. Then the max is stored in corresponding position i.e if we burst from [1][3] thats the best soln.

// So now you have a picture how we travel for the ballons of array 4 we travel in diagonal fashion in dp array 
// i.e [0][0] -> [1][1]-> [2][2]-> [3][3]-> [0][1]-> [1][2]-> [2][3]-> [0][3] which indirectly indicates increasing lenght bottom up
// uproach in the array the same we are computing and storing in the corresponding dp array location. Finally return [0][len-1]
// which len is the len of array and [0][len-1] represents whats the best soln if you burst from starting to ending in the best possible way.

//keep practicing this problem as its confusing

class Solution {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[][] dp = new int[len][len];
        
        for(int n =1 ; n  <= len; n++)
        {
            for(int i = 0; i <= len-n; i++)
            {
                int j = n + i -1;
                for(int k = i; k <= j; k++)
                {
                    int left = 1;
                    int right = 1;
                    if(i != 0) left = nums[i-1];
                    if(j != len-1) right = nums[j+1];
                    
                    int before = 0; int after = 0;
                    if(k != i) before = dp[i][k-1];
                    if(k != j) after = dp[k+1][j];
                    dp[i][j] = Math.max(dp[i][j],before + left * nums[k] * right + after);
                }
            }
        }
        return dp[0][len-1];
        
        
    }
}