// Time Complexity: O(kn)
// Space Complexity: O(kn)
// TLE
public class SuperEggDrop {
    public int superEggDrop(int k, int n) {
        if(n == 0 || k ==0)
            return 0;
        
        int dp[][] = new int[n+1][k+1]; // floors that can be covered
      
        int attempts = 0;
        while(dp[attempts][k] < n)// we cannot have more floors than attempt
        {
            //next attempt
            attempts++;
            for(int j = 1; j <= k; j++) // no of eggs
            {
                   // current attempt floor + previous floor break + previous no break
                   dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];
            }
        }
        
        return attempts;
    }
}

// Time Complexity: O(kn^2)
// Space Complexity: O(kn)
// TLE
public class SuperEggDrop {
    public int superEggDrop(int k, int n) {
        if(n == 0 || k ==0)
            return 0;
        
        int dp[][] = new int[k+1][n+1]; // moves array
        for(int j = 0; j <= n ; j++)
        {
            dp[1][j] = j; // 
        }
        
        for(int i = 2; i <= k; i++) // eggs
        {
            for(int j = 1; j <= n; j++) // floors
            {
                dp[i][j] = Integer.MAX_VALUE; // Max value
                for(int f = 1 ; f <= j; f++) // min for all floors
                {
                                                    // max because worse situation(break(floors below), no break(floors abv))
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.min(dp[i-1][f-1], dp[i][j-f]));
                }
            }
        }
        
        return dp[k][n];
    }
}
