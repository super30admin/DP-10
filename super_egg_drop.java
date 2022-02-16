class Solution {
    public int superEggDrop(int k, int n) {
        if(n == 0) return 0; //base case where if n is 0, we return 0
        int[][] dp = new int[n + 1][k + 1]; //initializing a 2d dp array with lengths equal to k + 1 and n + 1
        int attempts = 0; //integer variable attempts is initialized to 0
        while(dp[attempts][k] < n) { //if the value at first row of all the cols is less than n
            attempts++; //we increment the value of attempts
            for(int j = 1; j <= k; j++) { //we iterate through all the values until k
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j]; //wecompute the value of each index in the 2d matrix

            }
        }
        return attempts; //in the end, we return attempts;
    }
}
//tc and sc - O(kn)