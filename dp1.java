//problem1
class Solution {
    public int superEggDrop(int k, int n) {
      int[][] dp=new int[n+1][k+1];
      int at=0;
      while(dp[at][k]<n){
        at++;
        for(int j=1;j<=k;j++){
            dp[at][j]=1+dp[at-1][j-1]+dp[at-1][j];
        }
      }
      return at;  
    }
}
//problem2
class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n];
        for(int l=1;l<=n;l++){
            for(int i=0;i<=n-l;i++){
                int j=i+l-1;
                int max=0;
                for(int k=i;k<=j;k++){
                    int before=0;
                    if(i!=k){
                        before=dp[i][k-1];
                    }
                    int after=0;
                    if(j!=k){
                        after=dp[k+1][j];
                    }
                    int left=1;
                    if(i!=0){
                        left=nums[i-1];
                    }
                    int right=1;
                    if(j!=n-1){
                        right=nums[j+1];
                    }
                    max=Math.max(max,before+left*nums[k]*right+after);
                }
                dp[i][j]=max;
            }
        }
        return dp[0][n-1];
    }
}
