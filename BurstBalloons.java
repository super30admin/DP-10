Time Complexity = O(n^3)
Space Complexity = O(n^2)

class Solution {
    boolean debug = true;
    
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        int n = nums.length;
        int[][] gain = new int[n][n];
        
        for(int start = 1; start <= n; start++){
            for(int i = 0; i <= n-start;i++){
                //size = end - start +1;
                int end = i+start-1;
                
                for(int k = i; k <= end;k++){
                    int leftGain = 0,rightGain = 0;
                    
                    //i.....k.....end
                    if(k!=i)leftGain = gain[i][k-1];
                    if(k!=end)rightGain = gain[k+1][end];
                    
                    int leftBalloonVal = 1, rightBalloonVal = 1;
                    
                    if(i != 0)leftBalloonVal = nums[i-1];
                    if(end != n-1)rightBalloonVal = nums[end+1];
                    
                    gain[i][end] = Math.max(gain[i][end],
                                         leftGain + leftBalloonVal*nums[k]*rightBalloonVal + rightGain);
                }
            }
        }
        return gain[0][n-1];
        
    }
}