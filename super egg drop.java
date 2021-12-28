//Time complexity:- O(kn).
//space complexity:- O(kn).

class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp=new int[n+1][k+1];
        int tries=0;
        while(dp[tries][k]<n){// can come out of incomplete formation of matrix when any floor is greater than present value.
            tries++;
            for(int j=1;j<=k;j++){
                dp[tries][j]=1+dp[tries-1][j-1]+dp[tries-1][j];// breaking condition + non breaking condition where in breaking condition tries will be one decremented and eggs will be one less, where as in non breaking condition tries will be one less and eggs remains same. 
// + is as these are two different scenarios not two choices.
            }
        }
        return tries;
    }
}