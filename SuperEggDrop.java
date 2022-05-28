//Time Complexity : O(k.n)
//Space Complexity : O(k.n)
public class SuperEggDrop { 
	/**Approach: DP matrix of attempts/moves and eggs. Fill with total no of floors can be covered**/
	 public int superEggDrop(int k, int n) {
        //DP matrix of moves and eggs and filled with total no of floors.
        int[][] dp = new int[n+1][k+1];       
       
        int attempts = 0;
        while(dp[attempts][k] < n){
            attempts++;
            for(int j=1; j<=k; j++){                                
                //No of floors covered = 1 + Break + No Break .
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];            
            }
        }        
        return attempts;
    }	 
    
	// Driver code to test above
	public static void main (String[] args) {	
		SuperEggDrop ob  = new SuperEggDrop();			
		int k=3;
		int n=4;
		System.out.println("Min moves required to find the floor: "+ob.superEggDrop(k, n));
	}
}
