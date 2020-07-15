// 887.
// passes all test cases on leetcode
class Solution {
    public int superEggDrop(int K, int N) {
        return superEggDropOptimalDP(K, N);
    }
    
    //time - O(N^2 * K)
    //space - O(NK)
    private int superEggDropDP(int K, int N) {
        int[][] result = new int[K][N + 1]; //eggs along rows and floors along columns
        //base
        for(int i = 0; i <= N; i++)
        {
            //for the 1st row, number of eggs is 1, so number of attempts needed is same as number of floors
            result[0][i] = i; 
        }
        for(int numberOfEggs = 1; numberOfEggs < K; numberOfEggs++)
        {
            for(int floors = 1; floors <= N; floors++)
            {
                result[numberOfEggs][floors] = Integer.MAX_VALUE; //initially setting # of attempts to inf
                //for each floor from 1 to j, find number of attempts which is 1 + max(egg breaks, egg doesn't break)
                //if egg breaks, remaining eggs is numberOfEggs - 1, and explore all floors below current floor
                //else eggs is same(numberOfEggs is same) and explore all floors above current floor
                // => 1 + max(result[i - 1][currentFloor - 1], result[i][j - currentFloor])
                for(int currentFloor = 1; currentFloor <= floors; currentFloor++)
                {
                    result[numberOfEggs][floors] = Math.min(result[numberOfEggs][floors], 1 + Math.max(result[numberOfEggs - 1][currentFloor - 1], result[numberOfEggs][floors- currentFloor]));
                }
            }
        }
        return result[K - 1][N];
    }
    
    //time - O(NK)
    //space - O(NK)
    private int superEggDropOptimalDP(int K, int N) {
        int[][] result = new int[N + 1][K + 1]; //number of attempts along rows and eggs along columns
        //base
        //1st row and 1st col cells are zeros - (1st col - with 0 egss, max number of floors covered is 0 irrespective of number of attemps)
        //(1st row - with 0 attemps, max nummber of floors covered is 0 irrespective of number of eggs)
        int attempts = 0; //starting from 0th row
        while(result[attempts][K] < N)
        {
            attempts++; //increment attempts by 1 at start of each iteration of while()
            for(int egg = 1; egg <= K; egg++)
            {
                //if egg breaks, 1 attempt is used and remaining eggs is egg - 1
                //if egg doesn't break, 1 attempt is used and remaining eggs is egg
                //so max number of floors covered is 1 + sum of both possiblities
                result[attempts][egg] = 1 + result[attempts - 1][egg - 1] + result[attempts - 1][egg];
            }
        }
        return attempts;
    }
}
