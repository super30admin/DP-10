// Time Complexity : O(n^3)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int maxCoins(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int[][] gain = new int[nums.length][nums.length];
        int n = nums.length;
        for(int len = 1;len<=n;len++){
            for(int i = 0;i<=n-len;i++){
                int j = i+len-1;
                for(int k =i;k<=j;k++){
                    int leftGain=0,rightGain=0;
                    if(k!=i)leftGain = gain[i][k-1];
                    if(k!=j) rightGain = gain[k+1][j];
                    int leftBalloon = 1,rightBalloon = 1;
                    if(i!=0) leftBalloon = nums[i-1];
                    if(j!=n-1) rightBalloon = nums[j+1];
                    gain[i][j] = Math.max(gain[i][j],leftGain+leftBalloon*nums[k]*rightBalloon+rightGain);
                }
            }
        }
        return gain[0][nums.length-1];
    }
}