// Time Complexity : O(kn^2)
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : No, time limit exceeded

/*
for k = 2 and floor = 3, we have 3 options. Drop from floor 1, 2 and 3
If it breaks at 1, definitely breaks at other floors
If it doesn't, we have the top 2 floors to explore

            break       not-break
floor 1.    [1][0]      [2][2] 
floor 2.    [1][1]      [2][1]
floor 3.    [1][2]      [2][0]    //if it doesn't break at 3, def doesn't break at lower floors 

we take the max of break and not-break
min of which floor first 


*/
class Solution {
public:
    int superEggDrop(int k, int n) {
        if(k == 0 or n == 0)
            return 0;
        // rows = k+1 => eggs
        // columns = n+1 => floors
        vector<vector<int>> dp (k+1, vector<int> (n+1, 0));
        
        for(int j = 0; j<n+1; j++)
            dp[1][j] = j;
        
        for(int i = 2; i<k+1; i++){ // number of eggs
            for(int j = 1; j<n+1; j++) { // number of floors 
                dp[i][j] = INT_MAX;
                for(int f = 0; f<j; f++) {
                    dp[i][j] = min(dp[i][j] ,1 + max(dp[i-1][f], dp[i][j-f-1]));
                }
            }
        }
        return dp[k][n];
    }
};


// Approach 2: 
// Time Complexity : O(nk)
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : Yes


/*
rows: Number of attempts 
columns: Number of eggs 

upper limit of the number of rows (attempts) = number of floors 
The values in the DP array are the number of floors that can be explored with those many attempts and eggs 
Ex: 

dp[3][2] => 3 attempts, 2 eggs 
2 cases : break and not-break 
Total floors = summation of break and non-break 
we add 1 since we are exploring 1 flooor in this turn 
attempts reduces by 1 in both case 
= 1 + dp[2][1] + dp[2][2]

Once this numbers reaches floor, we return the row as the result
*/

class Solution {
public:
    int superEggDrop(int k, int n) {
        if(k == 0 || n == 0)
            return 0;

        vector<vector<int>> dp (n+1, vector<int>(k+1, 0));

        // rows: attempts
        for(int i = 1; i<n+1; i++) {
            // columns: eggs
            for(int j = 1; j<k+1; j++) {
                dp[i][j] = 1 + dp[i-1][j-1] + dp[i-1][j];
                // when the number of floors that can be explored reaches floors in the question, return the row (attempts)
                if(dp[i][n] >= n)
                    return i;
            }
        }
        return n;
    }
};