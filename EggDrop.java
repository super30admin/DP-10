class Solution {

    //Time Complexity: 0(kn^2) where n is the no. of floors and k is the no. of eggs
    //Space Complexity: 0(nk)

    public int superEggDrop(int k, int n) {
        if(n == 0 || k == 0){
            return 0;
        }

        int [][] dp = new int [k+1][n+1];   //creating a dp of size n+1 and k+1 for 0 floors and 0 eggs

        for(int j = 1; j <= n; j++){    //initially filling the 2st row or row with 1 eggs with 1,2,3,4 because I will have 1 egg to break irrespective of floor and I can have 1, 2, 3, 4 attemps to if the egg does not break
            dp[1][j] = j;
        }

        for(int i = 2; i <= k; i++){    //running a loop for eggs
            for(int j = 1; j <=n; j++){ //for floors
                dp[i][j] = Integer.MAX_VALUE;   //initiaizing with max value, because 1st value of dp i,j will be be 0 so in my dp array while taking min, I will always have 0
                for(int f = 1; f <= j; f++){    //running a loop from 1st floor to total floor. I am making an attempt at every floor from 1 to the total floors
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i-1][f-1], dp[i][j-f]));  //calculating the min between current value of dp and max between no break and break case
                }
            }
        }

        return dp[k][n];    //returning the last index
    }
}

//Optimizing on time

class Solution {

    //Time Complexity: 0(kn) where n is the no. of floors and k is the no. of eggs
    //Space Complexity: 0(nk)

    public int superEggDrop(int k, int n) {
        if(n == 0 || k == 0){
            return 0;
        }

        int [][] dp = new int [n+1][k+1];
        int attempts = 0;   //I return the attempts that I make

        while(dp[attempts][k] < n){ //till attempts and eggs remain below total floors
            attempts++; //I am making an attempt
            for(int j = 1; j <= k; j++){    //from 1 egg to total eggs
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];  //calculating between diagonal . Break and no break case
            }
        }


        return attempts;    //at the end, returning total attempts made
    }
}