class Solution {


    //DP Approach 3
    //Time Complexity: o(n*k)
    //Space Complexity: O(k), we can improve on space by O(k) via taking 2 rows or only 1 row

    public int superEggDrop(int k, int n) {

        int[] dp = new int[k+1];             //here we are taking attempts -> eggs dp and we try to find the maximum number of floors we can explore from the given attempt and given eggs

        int attempts = 0;                           //we start with zero attempt
        int prev = 0;
        int temp = 0;
        
        while(dp[k] < n){                 //check if we can explore the given number of floors or more using the current attempt and given eggs, if we can then just return the current attempts, otherwise iterate the loop

            attempts++;                             //as we are attempting, we have to increase the attempt counter
            prev = 0;
            for(int j = 1; j<=k; j++){              //for that attempt, we have to explore all the eggs that are given
                
                temp= dp[j];                           //take the current cell value in temp which will be useful for the next attempt for their break scenario
                
                        //Break,    Not Break
                dp[j] = 1 + prev + dp[j];          //as we are taking one attempt, we are exploring one floor so we have to add one, also in that attempt we have 2 possibilities, if egg breaks in that attempt, then we have one less attempt and one less egg available, if egg doesn't break in that attempt means we have one less attempt available and similar number of eggs, we can explore floors in both the possibilities, so we have to add them

                prev = temp;                            //update prev value to temp which is dp[j] which is original value of previous cell, which can useful for the next cell for their break scenario

            }
        }
        return attempts;
    }



    //DP Approach 2
    //Time Complexity: o(n*k)
    //Space Complexity: O(n*k), we can improve on space by O(k) via taking 2 rows or only 1 row

    // public int superEggDrop(int k, int n) {

    //     int[][] dp = new int[n+1][k+1];             //here we are taking attempts -> eggs dp and we try to find the maximum number of floors we can explore from the given attempt and given eggs

    //     int attempts = 0;                           //we start with zero attempt

    //     while(dp[attempts][k] < n){                 //check if we can explore the given number of floors or more using the current attempt and given eggs, if we can then just return the current attempts, otherwise iterate the loop

    //         attempts++;                             //as we are attempting, we have to increase the attempt counter

    //         for(int j = 1; j<=k; j++){              //for that attempt, we have to explore all the eggs that are given
    
    
    //             dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];          //as we are taking one attempt, we are exploring one floor so we have to add one, also in that attempt we have 2 possibilities, if egg breaks in that attempt, then we have one less attempt and one less egg available, if egg doesn't break in that attempt means we have one less attempt available and similar number of eggs, we can explore floors in both the possibilities, so we have to add them
    //         }
    //     }
    //     return attempts;
    // }




    //DP Approach 1: Time Limit Exceed Error
    //Time Complexity: o(n*n*k)
    //Space Complexity: O(n*k)

    // public int superEggDrop(int k, int n) {

    //     int[][] dp = new int[k+1][n+1];

    //     for(int j=0; j<=n; j++){
    //         dp[1][j] = j;
    //     }

    //     for(int i=2; i<=k; i++){   //i means number of eggs
    //         for(int j=1; j<=n; j++){        // j means number of floors

    //             dp[i][j] = Integer.MAX_VALUE;
    //             for(int f = 1; f<=j; f++){      //f means the floor from which we are droping the eggs

    //                 int attempts = 1 + Math.max(dp[i-1][f-1], dp[i][j-f]);      // for the current floor from which we are droping the eggs, there are 2 possibilities, eggs might broke or eggs might not broke, if egg breaks, then we have one less egg and we have to explore the below floor, also if egg is not broken, we have same egg and we have to explore  from the upper floor
    //                 dp[i][j] = Math.min(dp[i][j], attempts);
    //             }
    //         }
    //     }
    //     return dp[k][n];
    // }



    
    //DP Approach 2
    //Time Complexity: o(n*k)
    //Space Complexity: O(n*k)

    // public int superEggDrop(int k, int n) {
        
    //     //k -> # of eggs
    //     // n -> # of floors
    //     int[][] dp = new int[n+1][k+1];
    //     int attempts = 0;
          
    //     while(dp[attempts][k] < n){
            
    //         attempts++;
    //         for(int j =1; j<=k; j++){   
    //             dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];
    //         }   
    //     }
    //     return attempts;
    // }
    
    

    //DP Approach 1: Time Limit Exceed Error
    //Time Complexity: o(n*n*k)
    //Space Complexity: O(n*k)

//     public int superEggDrop(int k, int n) {
        
//         //k -> # of eggs
//         // n -> # of floors
//         int[][] dp = new int[k+1][n+1];
        
//         for(int i=1; i<=n; i++){
//             dp[1][i] = i;
//         }
        
//         for(int nEggs = 2; nEggs <=k ; nEggs++){
            
//             for(int nFloor = 1; nFloor <= n; nFloor++){
                
//                 dp[nEggs][nFloor] = Integer.MAX_VALUE;
                
//                 for(int currentFloor = 1; currentFloor<=nFloor; currentFloor++){
                 
//                     dp[nEggs][nFloor] = 
//                         Math.min(
//                             dp[nEggs][nFloor], 
//                             1 + Math.max(
//                                 dp[nEggs-1][currentFloor-1],
//                                 dp[nEggs][nFloor-currentFloor]
//                             )
//                         );
//                 }
//             } 
//         }
//         return dp[k][n]; 
//     }
}
