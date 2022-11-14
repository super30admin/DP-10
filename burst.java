/*
Time Complexity: O(n*n*n)
Space complexity: O(n*n)
*/
class Solution {
    public int maxCoins(int[] nums) {
        //DP CUT STRATEGY LIKE MCM 
        int arr[] = new int[nums.length + 2];
        arr[0] = arr[arr.length-1] = 1;
        
        for(int i = 0 ; i < nums.length ; i++)
            arr[i+1] = nums[i]; 
        
        int dp[][] = new int[arr.length+1][arr.length+1];
        return burstbaloon(arr , dp); 
    }
    public int burstbaloon(int[] arr , int[][] dp)
    {
        for(int gap = 2 ; gap < arr.length ; gap++)
        {
            for(int left = 0 ; left < arr.length - gap ; left++)
            {
                int right = left + gap;
                for(int i = left +1 ; i < right ; i++)
                {
                    dp[left][right] = Math.max(dp[left][right] , (dp[left][i] + dp[i][right] + (arr[left]*arr[right]*arr[i]))); 
                }
            }
        }
    return dp[0][arr.length-1];
    }
}