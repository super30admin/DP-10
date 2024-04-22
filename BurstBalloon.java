// TC - O(N*N*N)
// SC - O(N*N)

// TODO - Return order in which balloons are burst

public class BurstBalloon {

    class Solution {
        public int maxCoins(int[] nums) {
            int arrLen = nums.length;
            int[][] dp = new int[arrLen][arrLen];

            for (int burstLen = 1; burstLen <= arrLen; burstLen++) { // Burstible Array
                for (int startIdx = 0; startIdx <= arrLen - burstLen; startIdx++) {
                    int endIdx = startIdx + burstLen - 1; // For arrLen=4 and burstLen=3 => [0,2],[1,3]
                    for (int curr = startIdx; curr <= endIdx; curr++) { // Balloons between startIdx and endIdx are burstible
                        int currBurstAtLastValue = Integer.MIN_VALUE;
                        // Before curr
                        int beforeCurr = 0;
                        if (curr != startIdx) {
                            beforeCurr = dp[startIdx][curr - 1];
                        }

                        // At curr
                        int left = 1;
                        int right = 1;
                        int atCurr = 1;
                        if (startIdx != 0) {
                            left = nums[startIdx - 1];
                        }
                        if (endIdx != arrLen - 1) {
                            right = nums[endIdx + 1];
                        }
                        atCurr = left * nums[curr] * right;

                        // After curr
                        int afterCurr = 0;
                        if (curr != endIdx) {
                            afterCurr = dp[curr + 1][endIdx];
                        }

                        currBurstAtLastValue = beforeCurr + atCurr + afterCurr;

                        dp[startIdx][endIdx] = Math.max(currBurstAtLastValue, dp[startIdx][endIdx]);
                    }
                }
            }
            return dp[0][arrLen - 1];
        }
    }
}