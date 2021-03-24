//Method 1: Iterate through the dp array of eggs vs floors computing the best of the worst number of moves.
// Fill the dp array egg 1 row with the worst number of moves equals floor itself.
// For every floor in the eggs vs floor compute the worst possible solution of moves if we are performing the egg drop in that
// particular floor. Ex in [2][3] 2 egg 3 floor we have to go through all the floors of Break and No break condition and store the
// result which gives the min number of moves

//ex:  in [2][3] 3 max floors but we compute the moves in 1,2,3 floor and store the best 
//result so [j-f]  leads the no of upper floors left to try in no break condition, and [f-1] floors below it to try in break condition

//Time Complexity: o(k*n^2)
// Space Complexity: o(k *n)
class Solution {
    public int superEggDrop(int k, int n) {
        if(k == 0) return 0;
        int[][] dp = new int[k+1][n+1];
        //preprocess the number of attemps possible is number of floors itself with one egg in worst case
        for(int i = 0; i < n+1; i++)
        {
            dp[1][i] = i;
        }
        //Process the dp 
        for(int i = 2; i < k+1; i++)
        {
            for(int j = 1; j < n+1; j++)
            {
                dp[i][j] = Integer.MAX_VALUE;
                for(int f = 1; f <= j; f++)
                {
                    // Compute the Break [i-1][f-1](floors below it if breaks) else [i][j-f] j is the floors until we are considering
                    // and f is the individual floor ex in [2][3] 3 max floors but we compute the moves in 1,2,3 floor and store the best
                    // result so [j-f]  leads the no of upper floors left to try in no break condition.
                    dp[i][j] = Math.min(dp[i][j],1+ Math.max(dp[i-1][f-1], dp[i][j-f]));
                }
            }
        }
        return dp[k][n];
    }
}



//Method 2: Determine max number of floors we can cover given the number of attempts and eggs if it is more than that of the floors
// then return the attempts. The max floors is 1(current attempt) + (No Breakcondition)[attempts-1][eggs] + Break condition([attempts-1][eggs-1])

//Time Complexity: o(k*n)
// Space Complexity: o(k *n)
class Solution {
    public int superEggDrop(int k, int n) {
        if(k == 0) return 0;
        int[][] dp = new int[n+1][k+1];
        for(int i = 1; i < n+1; i++)
        {
            for(int j = 1; j < k+1; j++)
            {
                dp[i][j] = 1 + dp[i-1][j-1] + dp[i-1][j];
                if(dp[i][j] >= n) return i;
            }
        }
       return -1; 
    }
}