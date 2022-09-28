// Time Complexity : O(kn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't figure out until class

class EggDrop {
    public int superEggDrop(int k, int n) {
        int attempts = 0;
        int [][] dp = new int[n+1][k+1];
        while(dp[attempts][k]<n){
            attempts++;
            for(int j=1;j<=k;j++){
                dp[attempts][j]=1+dp[attempts-1][j-1]+dp[attempts-1][j];
            }
        }

        return attempts;
    }
}