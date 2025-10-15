
//Time Complexity: O(k*n*logn)
//Space Complexity: O(k*n)

//Did this code successfully run on Leetcode : Yes


//fill the first row with 1 to n as with 1 egg we need to try all the floors
//for each egg and floor we do binary search to find the optimal floor to drop from
//we calculate the max of egg breaks and egg does not break and take the min of all
//these max values to get the optimal solution

class Solution {
    public int superEggDrop(int k, int n) {
        int dp[][]=new int[k+1][n+1];
        for(int i=1;i<=n;i++)
            dp[1][i]=i;
        
        for(int i=2;i<=k;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=Integer.MAX_VALUE;
                int l=1,h=j;
                //binary search for floors
                while(l<=h){
                    int f=l+(h-l)/2;
                    int br=dp[i-1][f-1];  //explore below
                    int noBr=dp[i][j-f];   //explore above
                    dp[i][j]=Math.min(dp[i][j],1+Math.max(br,noBr));
                    if(br>noBr)
                        h=f-1;
                    else
                        l=f+1;
                }
            }
        }
        return dp[k][n];
    }
}