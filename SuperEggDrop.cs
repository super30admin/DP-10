using System;
using System.Collections.Generic;
using System.Text;

namespace DynamicProgramming
{
    public class SuperEggDrop
    {
        /*
         * T.C: O(k*n)
         * S.C: O(K*n)
         * 
         */
        public int SuperEggDrop1(int k, int n)
        {
            if (n == 0 || k == 0) return 0;

            int[,] dp = new int[n + 1, k + 1];

            int attempt = 0;

            //Console.WriteLine(dp[attempt, k]);
            while (dp[attempt, k] < n)
            {
                attempt++;
                for (int i = 1; i <= k; i++)
                {
                    dp[attempt, i] = 1 + dp[attempt - 1, i - 1] + dp[attempt - 1, i];

                    if (dp[attempt, i] >= n)
                        return attempt;

                }
            }

            return attempt;
        }
    }
}
