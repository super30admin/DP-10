//O(N^3) time
//O(N^2) space

class Solution {
    public int maxCoins(int[] nums2) {
        int nums[] = new int[nums2.length+2];
        int dp[][] = new int[nums.length][nums.length];

        for(int i=0;i<nums2.length;i++)
            nums[i+1] = nums2[i];

        nums[0] = nums[nums.length-1] = 1;

        int end;
        for(int length = 0; length <= nums2.length-1; length++){

            for(int start = 1; start<=nums2.length-length;start++){
                end = start + length;
                if(start == end){
                    dp[start][start] = nums[start-1] * nums[start] * nums[start+1];
                    continue;
                }
                for(int i = start;i<=end;i++)
                    dp[start][end] = Math.max(dp[start][end], dp[start][i-1] + dp[i+1][end] + nums[start-1]*nums[i]*nums[end+1]);

            }

        }
        return dp[1][dp[0].length-2];
    }
}