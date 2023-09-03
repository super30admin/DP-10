import java.util.Scanner;

public class SuperEggDropDPAttempts {

        // Dynamic Programming - Time O(n*n*k) and Space O(n*k)
        // DP[eggs][floors] = attempts

        public int superEggDrop(int k, int n) {

            // dp 2-D array
            int[][] dp = new int[k+1][n+1];    //   O(n*k) space

            // 1 egg
            for(int j = 1; j <= n; j++) {

                dp[1][j] = j;
            }

            // 2 or more eggs
            for(int i = 2; i <= k; i++) {      //   O(n*n*k)
                //
                for(int j = 1; j <= n; j++) {
                    //
                    int min = Integer.MAX_VALUE;
                    // start check from each floor
                    for(int f = 1; f <= j; f++) {
                        // if egg does not break, search upwards if breaking point is still upper
                        // if egg breaks, search downwards if breaking point is still lower
                        min = Math.min(min, 1 + Math.max(dp[i-1][f-1], dp[i][j-f]));
                    }
                    // take best floor case of worst case in each floor
                    dp[i][j] = min;
                }
            }
            // output
            return dp[k][n];
        }

        public static void main(String[] args) {

            SuperEggDropDPAttempts obj = new SuperEggDropDPAttempts();

            Scanner scanner = new Scanner(System.in);

            System.out.println("eggs: ");
            int k = scanner.nextInt();

            System.out.println("floors: ");
            int n = scanner.nextInt();

            int answer = obj.superEggDrop(k, n);
            System.out.println("the minimum number of moves that you need to determine " +
                    "with certainty what the value of f is " + answer);

        }

}

/*
Time Complexity = O(n*n*k)
Space Complexity =  O(n*k)
*/

