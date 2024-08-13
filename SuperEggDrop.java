public class SuperEggDrop {
    /***
     Time complexity - o(NK)
     Space complexity -o(NK)
     Approach - Building dp array with eggs on col and attempts on rows until the
     value of attempts become grater or equal to n.
     take extra row/ col - for zero egg zero attempt case.
     fill first row and col with 0. (in java they are filled with zero by default)
     for every attempt calculate the one attempt +  value inthe coordinates of (break) do not break.
     1 + break [prevRow][number of eggs left after breaking one] + [prevRow][number of eggs left (none broke)]
     Calculate all this until number of attempts become equal to or more than n
     keep attempts variable. and increment before every iteration.
     */
    public int superEggDrop(int k, int n) {
        if(k==0 || n==0){
            return 0;
        }
        int [][]dp = new int[n+1][k+1];
        int attempts =0;
        while(dp[attempts][k]<n){
            attempts++;
            for(int j =1;j<k+1;j++){
                dp[attempts][j]= 1+ dp[attempts-1][j-1] + dp[attempts-1][j];
            }
        }
        return attempts;
    }
}
