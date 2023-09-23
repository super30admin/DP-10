// Time Complexity : O(n^3)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int maxCoins(int[] nums) {
        //dp matrix
        int[][] result = new int[nums.length][nums.length];
        //burstible array size 
        for(int len = 1; len <= nums.length; len++){
            //Getting the burstible array
            for(int i = 0; i< nums.length - len+1; i++){
                int end = i+len-1;
                for(int j=i; j<=end; j++){
                    //left
                    int left = 0;
                    if(j-1 >= i){
                        left = result[i][j-1];
                    } 
                    //right
                    int right = 0;
                    if(j+1 <= end){
                        right = result[j+1][end];
                    }
                    //middle
                    //middle left
                    int l = 1;
                    if(i-1 >= 0){
                        l = nums[i-1];
                    }
                    //middle right
                    int r = 1;
                    if(end+1 < nums.length){
                        r = nums[end+1];
                    }
                    int middle = l * nums[j] * r;
                    int fin = left + middle + right;
                    result[i][end] = Math.max(result[i][end], fin);
                }
            }
        }

        return result[0][nums.length-1];
    }
}