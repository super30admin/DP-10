// Time Complexity :O(K*N)
// Space Complexity :O(KN)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int superEggDrop(int k, int n) {
        int dp[][]= new int[n+1][k+1];
        
        int attempt=0;
        while(dp[attempt][k]<n){
            attempt++;
            for(int i=1;i<=k;i++){
                dp[attempt][i]=1+dp[attempt-1][i-1]+dp[attempt-1][i];//1+eggbreak +not break
            }
            
        }
        return attempt;
    }
}