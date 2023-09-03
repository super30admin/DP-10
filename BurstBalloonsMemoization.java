import java.util.Scanner;

public class BurstBalloonsMemoization {

        // Dynamic Programming - Time O(n*n*n) and Space O(n*n)

        public int maxCoins(int[] nums) {

            // memoization dp array
            int n = nums.length;
            int[][] dp = new int[n][n];

            // possible lengths of burstable balloon array
            for(int length = 1; length <= n; length++) {

                // beginning of burstable balloon array
                for(int begin = 0; begin <= n - length; begin++) {

                    // end of burstable balloon array
                    int end = begin + length - 1;

                    int max = Integer.MIN_VALUE;

                    // iterate over burstable balloon array
                    for(int burstable = begin; burstable <= end; burstable++) {

                        // coins earned left to burstable balloon
                        int left = 0;

                        if(burstable != begin) {

                            left = dp[begin][burstable - 1];
                        }

                        // coins earned right to burstable balloon
                        int right = 0;

                        if(burstable != end) {

                            right = dp[burstable + 1][end];
                        }

                        // when bursting burstable balloon
                        int curr = nums[burstable];

                        int before = 1;
                        if(begin != 0) {

                            before = nums[begin - 1];
                        }

                        int after = 1;
                        if(end != n - 1) {

                            after = nums[end + 1];
                        }

                        // (left + current + right) earnings
                        max = Math.max(max, left  +  before * curr * after + right);
                    }

                    // fill in memoization dp array
                    dp[begin][end] = max;
                }
            }
            // output
            return dp[0][n-1];
        }

        public static void main(String[] args) {

            BurstBalloonsMemoization obj = new BurstBalloonsMemoization();

            Scanner scanner = new Scanner(System.in);

            System.out.println("length of nums: ");
            int n = scanner.nextInt();

            int[] nums = new int[n];

            System.out.println("nums: ");
            for(int i = 0; i < n; i++) {

                nums[i] = scanner.nextInt();
            }

            int answer = obj.maxCoins(nums);

            System.out.println("the maximum coins we can collect by bursting the balloons wisely: " + answer);
        }

}

/*
Time Complexity = O(n*n*n)
Space Complexity = O(n*n)
*/