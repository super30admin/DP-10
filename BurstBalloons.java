// Time Complexity : O(n^3)
// Space Complexity : O(n^2)
public class BurstBalloons { 
	/**Approach: DP**/	
	public int maxCoins(int[] nums) {
        int n= nums.length;
        int[][] dp = new int[n][n];
        //take subarray
        for(int len=1; len<=n; len++){            
            for(int i=0; i<=n-len; i++){//i = stating index of burstible subarrays 
                int j= i + len - 1; //j = end index of burstible subarray
                for(int k=i; k<=j; k++){ //k = index of balloon to be burst at the end
                    int before= 0;
                    int after= 0;                    
                    //before + left * balloon * right + after
                    if(i != k) 
                        before = dp[i][k-1];
                    if(j != k)
                        after = dp[k+1][j];
                    
                    //Left and right are out i till j range
                    int left = 1;
                    int right = 1;                    
                    if(i != 0) 
                        left = nums[i-1];
                    if(j != n-1)
                        right = nums[j+1];
                    
                    //Fill calculated value in dp matrix
                    dp[i][j] = Math.max(dp[i][j], before + left * nums[k] * right + after);
                }
            }
        }
        
        return dp[0][n-1];//top right corner
    }
    
	// Driver code to test above
	public static void main (String[] args) {	
		BurstBalloons ob  = new BurstBalloons();			
		int[]nums = {3,1,5,8};
		System.out.println(" Maximum coins we can collect by bursting the balloons wisely are: "+ob.maxCoins(nums));
	}
}
