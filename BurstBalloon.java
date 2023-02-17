import java.util.Arrays;

// Time O(N^3)
// Space O(N^2)
public class BurstBalloon {
	
	 public int maxCoins(int[] nums) {
	        int n = nums.length;
	        // create a new input array with 1 add at the last indexes 
	        int[] arr = new int[n+2];
	        // initialize first and last as 1 in the new input array 
	        arr[0] = 1; arr[n+1] = 1;
	        for(int i = 1; i <= n; i++) 
	            arr[i] = nums[i-1];
	        // dp array 
	        int dp[][] = new int[n+1][n+1];
	        for(int[] a: dp) Arrays.fill(a, -1);
	        return rec(arr, 1, n, dp);
	    }
	    public int rec(int[] arr, int left, int right, int[][] dp){
	        // base case 
	        if(left > right) return 0;
	        // dp 
	        if(dp[left][right]!=-1) return dp[left][right];

	        int max = 0;
	        //burst all balloons and recursively calculate the sum for left and right sub array 
	        for(int i = left; i<=right ; i++){
	            int costOf_left = rec(arr, left, i-1, dp);
	            int costOf_last = arr[left-1]*arr[i]*arr[right+1];
	            int costOf_right = rec(arr, i+1, right, dp);
	            max = Math.max(max, costOf_left+costOf_last+costOf_right); 
	        }
	        return dp[left][right] = max;
	    }
}
