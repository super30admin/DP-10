// Time Complexity : O(K*N)
// Space Complexity : O(K*N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp=new int[N+1][K+1];
        
        int attempts=0;
        while(dp[attempts][K]<N){
            attempts+=1;
            for(int i=1;i<=K;i++){
                dp[attempts][i]=1+ dp[attempts-1][i-1]+dp[attempts-1][i];
            }
        }
        return attempts;
        
    }
}