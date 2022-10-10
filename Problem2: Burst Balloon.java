O(NxNxN) time and spcae complexity

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int [][] dp = new int [n][n];
        for(int l=1;l<=n;l++){
            //forming all possible burstible array of size l
            for(int i=0;i<=n-l;i++){//start index of burstible arrays
                int j = i+l-1; // end index of burstible arrays
                //Burst balloon at kth index in the end
                for(int k =i;k<=j;k++){
// beforeLeft -> coins gathered by balloons getting burst before the kth balloon which are in left of the kth balloon in burstible array
// beforeRight -> coins gathered by balloons getting burst before the kth balloon which are in right of the kth balloon in burstible array
//left -> coins value remaining(still alive) of the balloon at the left of the balloon at kth index in nums array after all the bursting
//right -> coins value remaining(still alive) of the balloon at the right of the balloon at kth index in nums array after all the bursting
             //   beforeLeft + left*curr*right + beforeRight
    int left = 1; //taking 1 bcs if the curr balloon is at left corner in nums array
    int right = 1; //taking 1 bcs if the curr balloon is at right corner in nums array
                    if (j != n-1){
                        right = nums[j+1];
                            }
                    if (i != 0){
                        left = nums[i-1];
                            }
    int beforeLeft =0; //0 if we only have 1 element in our burstible array
    int beforeRight =0; //0 if we only have 1 element in our burstible array
                if(i !=k){
                 beforeLeft = dp[i][k-1];   
                        }
                if (k!=j){
                     beforeRight = dp[k+1][j]; 
                    }
            dp[i][j] = Math.max(dp[i][j], beforeLeft+ left*nums[k]*right +beforeRight);
                }
            }
        }
    return dp[0][n-1];
    }
}
