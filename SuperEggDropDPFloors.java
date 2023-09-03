import java.util.Scanner;

public class SuperEggDropDPFloors {

        // Dynamic Programming - Time O(n*k) and Space O(n*k)
        // DP[attempts][eggs] = floors
        // Invert problem to find explore number of floors than can be covered with given number of attempts and eggs

        public int superEggDrop(int k, int n) {

            // number of attempts need not be more than number of floors
            int[][] dp = new int[n+1][k+1];      // O(n*k) space

            // before loop
            int attempts = 0;

            // until explorable floors crosses given number of floors
            while(dp[attempts][k] < n) {         // O(n*k)

                // increase number of attempts for every entry in while loop
                attempts++;

                // iterate over eggs in a row i.e. for a given number of attempts
                for(int j = 1; j <= k; j++) {

                    // make one attempt and add break, no break scenarios to get explorable floors
                    dp[attempts][j]  = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];
                }
            }
            // output
            return attempts;
        }

        public static void main(String[] args) {

            SuperEggDropDPFloors obj = new SuperEggDropDPFloors();

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
Time Complexity = O(n*k)
Space Complexity = O(n*k)
*/