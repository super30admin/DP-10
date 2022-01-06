// egg drop

//tc n*k
//sc n*k

// definition of dp
// i is moves/floors(interchangeable) and j is eggs
//dp[i][j] is means for i moves and j eggs how many floors i can cover; hence at the end if i find more than n floors then my solution must be that i

class Solution {
    public int superEggDrop(int k, int n) {
        
        int[][] dp = new int[n+1][k+1];
        
        for(int i = 1; i < n+1; i++){
            
            for(int j = 1; j < k+1; j++){
                
                int broken = dp[i-1][j-1];
                
                int notBroken = dp[i-1][j];
                
                int floors = 1+ broken + notBroken;
                
                dp[i][j] = floors;
                
                if(floors >= n) return i;
            }
            
        }
        return 0;
        
    }
}
