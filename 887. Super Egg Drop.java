// Time Complexity : O(n*k*logn)
// Space Complexity : O(n*k)
// Method used : DP

class Solution {

    public int superEggDrop(int k, int n) {

        int[][] dp = new int[n + 1][k + 1];

        //Base case : if(n == 1) return 1;
        for(int j = 0; j < k + 1; j++) dp[1][j] = 1;

        // Base case : if(eggs == 1) return n;
        for(int i = 0; i < n + 1; i++) dp[i][1] = i;

        // We start our iteration from i = 2 because we already initialized the 1st floor
        for(int i = 2; i < n + 1; i++)
        {
            // We start our iteration from j = 2 because we already initialized the 1st egg column
            for(int j = 2; j < k + 1; j++)
            {
                int minimum = Integer.MAX_VALUE;

                // Apply binary search instead of linear search
                int low = 1, high = i;

                while(low <= high)
                {
                    int mid = low + (high - low) / 2;

                    int egg_doesnot_break = dp[i - mid][j];
                    int egg_breaks = dp[mid - 1][j - 1];

                    // Find out all the maximum moves
                    int temp = 1 + Math.max(egg_doesnot_break, egg_breaks);

                    // Pick a minimum among all those max moves
                    if(temp != Integer.MIN_VALUE) minimum = Math.min(minimum, temp);

                    // This means that when we are mid floor the value of egg_doesnot_break is more. It means the egg didn't break at 
                    // mid floor so we can move to move floors above mid
                    if(egg_doesnot_break > egg_breaks) low = mid + 1;

                    else high = mid - 1;

                }

                dp[i][j] = minimum;
            }
        }

        return dp[n][k];
    }
}
