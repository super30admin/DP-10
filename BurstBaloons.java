// Time Complexity : O(n^3) => Each iteration we create a window of size 1 till n and explore all the elements
// Space Complexity : O(n * n) size of DP Matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null|| nums.length == 0)
            return 0;
        int n = nums.length; 
        int[][] coinGain = new int[n][n];
        
        //Set a window of 1 and calculate the gain for bursting each baloons in the window.
        // Increment the window Size to 2 and calculate the MaxCoin gain by bursting each baloons.
        
        // We have only 2 details for bursting baloons, either bursting the Baloon FIRST or bursting the baloon LAST
        // If baloon bursted first, neighboring unbursted values will be used to cal current gain
        // If baloon bursted last, GAIN from neighbours will be used
        // We should choose to burst the baloon LAST so that MAXGAIN can be computed for each baloon busted last.
        
        
        int leftGain = 0, rightGain = 0;
        int leftBaloon = 1, rightBaloon = 1;  // Values for extreme baloons
       
        for(int windowSize = 1; windowSize <= n; windowSize++){
            for(int start = 0; start <= n-windowSize; start++){
                int end =  start + windowSize-1; //First cycle, Start at 0 and end at 0, Start at 1 end at 1,then 2,2, 3,3 and so on
                                         // Second Cycle when windowSize is 2 -> Start at 0 end at 1, Start at 1, end at 2 then 2, 3 then 3, 4 and so on.
            for(int k = start; k <= end; k++ ){  // Pointer moving within the window.
                
                if(k == start)  
                    leftGain = 0;
                else 
                    leftGain = coinGain[start][k-1];  // Get the gain from previously Calculated Matrix.
                    
                if(k == end)  
                    rightGain = 0;
                else
                    rightGain =  coinGain[k+1][end];
                
                // Choose Left baloon and Right Baloon for extreme cases.
                if(start != 0) 
                    leftBaloon = nums[start-1];
                else
                    leftBaloon = 1;
                if(end != n-1) 
                    rightBaloon = nums[end+1];
                else
                    rightBaloon = 1;
                
                coinGain[start][end] = Math.max(coinGain[start][end], 
                                               leftGain +
                                                leftBaloon * nums[k] *rightBaloon + 
                                               rightGain);
                
            }
            
            }
        }
        
        return coinGain[0][n-1];
    }
}
