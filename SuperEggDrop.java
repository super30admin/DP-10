
public class SuperEggDrop {
	//Time Complexity: O(k * n^2)
	//Space Complexity: O(k * n)
	class NonOptimizedDP {
	    public int superEggDrop(int K, int N) {
	        int[][] dp = new int[K + 1][N + 1];
	        for(int j = 1; j < dp[0].length; j++){
	            dp[1][j] = j;
	        }
	        
	        for(int i = 2; i <= K; i++){
	            for(int j = 1; j <= N; j++){
	                dp[i][j] = Integer.MAX_VALUE;
	                for(int l = 1; l <= j; l++){
	                    dp[i][j]= Math.min(dp[i][j],1 + Math.max(dp[i - 1][l - 1], dp[i][j - l]));
	                }
	            }
	        }
	        return dp[K][N];
	    }
	}
	
	//Time Complexity: O(k * n)
	//Space Complexity: O(k * n)
	class OptimizedDP {
	    public int superEggDrop(int K, int N) {
	        int[][] dp = new int[N + 1][K + 1];
	        int attempts = 0;
	        while(dp[attempts][K] < N){
	            attempts++;
	            for(int i = 1; i <= K; i++){
	                dp[attempts][i] = 1 + dp[attempts - 1][i - 1] + dp[attempts - 1][i];
	            }
	        }
	        return attempts;
	    }
	}
}
