// Time Complexity : O(n^3)
// Space Complexity : O(n^2)

// Approach:
// 1. We will use DP to solve this problem.
// 2. We will create a 2D array of size n*n.
// 3. We will iterate over the array and find the max value for each subarray.
// 4. We will find the max value by iterating over the subarray and finding the max value for each subarray.
// 5. We will find the max value by adding the value of the current element and the product of the left and right element.


class BurstBalloons {
    public static void main(String[] args){
        int[] nums = {3,1,5,8};
        BurstBalloons bb = new BurstBalloons();
        System.out.println(bb.maxCoins(nums));
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if(nums == null || nums.length == 0) return 0;
        int[][] dp = new int[n][n];

        for(int l = 1; l<=n ; l++ ){
            for(int i =0; i<=n-l;i++){
                int j = i+l-1;
                int max = Integer.MIN_VALUE;
                for(int k= i; k<=j;k++){
                    int left = 1;
                    int right =1;
                    int curr;
                    if(j!=n-1) {
                        right = nums[j+1];
                    }
                    if(i!=0){
                        left = nums[i-1];
                    }
                    curr = nums[k]*left*right;
                    int before =0;
                    int after=0;
                    if(k!=i){
                        before = dp[i][k-1];
                    }
                    if(k!=j){
                        after = dp[k+1][j];
                    }
                    max = Math.max(max, before+after+curr);
                }
                dp[i][j] = max;    
            }
        }
        return dp[0][n-1];
    }
}