//Time Complexity: O(k*n*n)
//k*n -> since a dp matrix; row*col
//n -> iterating over the row again to find max and min of the scenario

class Solution {
    public int superEggDrop(int K, int N) {
        //dp of size floor+1 and egg+1
        int[][] dp = new int[K+1][N+1];
        
        //row 0-> has all 0's by default
        //for the 1st dp row; copy the j
        for (int j = 1; j < dp[0].length; j++){
            dp[1][j] = j;
        }
        //from row 2-> till length of dp
        //where rows is egg
        for (int i = 2; i < dp.length; i++) {
            //from col 0 -> last col
            //where col is floor
            for (int j = 1; j < dp[0].length; j++) {
                //initializing dp with max value
                //since at the end, minimum of the worst cases is required
                dp[i][j] = Integer.MAX_VALUE;
                //from floor 1 till the last
                //at every floor
                for (int floor = 1; j <= j; floor++) {
                    //dp[egg][floor]= min of worst case scenario
                    //1 + max of (if egg breaks, if egg doesn't break)
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i-1][floor - 1], dp[i][j - floor]));
                }
            }
        }
        return dp[K][N];
    }
}

/******************************************************************************************************** */

//Time Complexity: O(k*n)
//k*n -> since a dp matrix; row*col

class Solution {
    public int superEggDrop(int K, int N) {
        //dp of size egg+1 and floor+1
        int[][] dp = new int[N+1][K+1];
        //attempts -> floor
        int attempts = 0;
        //till (attempts, egg) value doesnot exceed number of total given floors
        while(dp[attempts][K] < N){
            //when successful, increment attempt level and proceed
            attempts++;
            //from row 1 -> till last column
            for(int j=1; j<= K; j++){
                //since we are not checking worst case here;
                //progressively checking each case in a cummulative way
                //we are adding dp's with 1 attempt in this case
                dp[attempts][j] = 1+ dp[attempts-1][j-1] + dp[attempts-1][j];
            }
        }
        //return when value of attempts becomes more than given floor number
        return attempts;
    }
}