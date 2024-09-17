/*
 * Time Complexity : O(KN)
 * Space Complexity : O(KN)
 */
public class SuperEggDrop {
	
	public int superEggDrop(int K, int N) {
	     
        int[][] dp = new int[N+1][K+1];
        
        int attempts = 0;
        while(dp[attempts][K] < N){
            attempts++;
            for(int i = 1; i< dp[0].length; i++){
                dp[attempts][i] = 1 + dp[attempts - 1][i-1] + dp[attempts - 1][i]; 
            }
        }
        
        return attempts;
    }

}
