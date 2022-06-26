// Time Complexity : O(N*K)
// Space Complexity : O(N*K)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
/*
 * Appraoch: At every step, there are two possibilities - egg cracks, or wont. 
 * We take the minimum value from the egg crack and wont possibility.
 * 
 */
import java.util.*;
public class SuperEggDrop{

    public static int superEggDrop(int k,int n)
    {
        if(n==0 || k == 0) return 0;

        int[][] dp = new int[k+1][n+1];

        for(int j =1;j<=n;j++)
        {
            dp[1][j] = j;
        }

        for(int i = 2;i<=k;i++)
        {
            for(int j=1;j<=n;j++)
            {
                dp[i][j] = Integer.MAX_VALUE;

                for(int f=1;f<=j;f++)
                {
                    dp[i][j] = Math.min(dp[i][j], 1+Math.min(dp[i-1][f-1], dp[i][j-f]));
                }
            }
        }

        return dp[k][n];
    }

    public static void main(String args[])
    {
        System.out.println(superEggDrop(1, 2));
    }
}