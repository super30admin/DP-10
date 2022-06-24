using System;
using System.Collections.Generic;
using System.Text;

namespace DynamicProgramming
{
    public class BurstBalloons
    {
        /*
         * T.C: O(n2)
         * S.C: O(n2)
         */
        public int MaxCoins(int[] nums)
        {
            if (nums == null || nums.Length == 0) return 0;

            int n = nums.Length;
            int[,] dp = new int[n, n];

            for (int len = 1; len <= n; len++)
            {
                //starting index
                for (int i = 0; i <= n - len; i++)
                {
                    int j = i + len - 1;
                    for (int k = i; k <= j; k++)
                    {
                        int before = 0;
                        if (k != i)
                        {
                            before = dp[i, k - 1];
                        }
                        int after = 0;
                        if (k != j)
                        {
                            after = dp[k + 1, j];
                        }

                        int left = 1;
                        if (i != 0)
                        {
                            left = nums[i - 1];
                        }
                        int right = 1;
                        if (j != n - 1)
                        {
                            right = nums[j + 1];
                        }
                        dp[i, j] = Math.Max(dp[i, j], before + left * nums[k] * right + after);
                    }
                }
            }

            return dp[0, n - 1];


        }
    }
}
