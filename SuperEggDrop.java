import java.util.Arrays;

// Time O(N^2 * K)
// Space (N*K)

public class SuperEggDrop {

    public int superEggDrop(int k, int n) {
       int [][] dp = new int[k+1][n+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return helper(k,n,dp);
    }
   
    public int helper(int eggs, int floor,int[][] dp){
       // base  
    if(floor==0 || floor==1 || eggs==1) // if no of floors are 1 or 0 or only 1 eggs thn return n 
        return floor;

    // logic 
    if(dp[eggs][floor]!=-1)
        return dp[eggs][floor];

    int res = Integer.MAX_VALUE;

    for(int i=1;i<=floor ;i++){
        int max = 1+Math.max(helper(eggs-1,i-1,dp),helper(eggs,floor-i,dp));
        res= Math.min(max,res);
    }
        dp[eggs][floor] = res;
        return dp[eggs][floor]; 
    }
    
}
