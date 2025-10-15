
//Time Complexity: O(n^3)
//Space Complexity: O(n^2)

//Did this code successfully run on Leetcode : Yes

//We use dp with permutations to solve dp with permutations.
//We try bursting each ballon in the range and calculate the coins we get from it
//and add it to the coins we get from the left and right side of the ballon
//We also take care of the edge cases where the ballon is at the start or end of the array
//We take the max of all these values to get the optimal solution

class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n];
        for(int le=1;le<=n;le++){   //length
            for(int i=0;i<=n-le;i++){   //start indices
                int j=i+le-1;
                for(int k=i;k<=j;k++){   // permutaion of bursting the ballons
                    int before=0,after=0;
                    if(i!=k)
                        before=dp[i][k-1];
                    
                    if(j!=k)
                        after=dp[k+1][j];

                    int prev=1,next=1;
                    if(i>0)
                        prev=nums[i-1];

                    if(j<n-1)
                        next=nums[j+1];

                    int itself=prev*nums[k]*next;

                    dp[i][j]=Math.max(dp[i][j],before+after+itself);
                }
            }
        }
        return dp[0][n-1];
    }
}