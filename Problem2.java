// Time Complexity :O(n^3)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int maxCoins(int[] nums) {
        int dp[][]= new int[nums.length][nums.length];
        int n= nums.length;
        int before=0, after=0;
        int mul_left=1, mul_right=1;
        for(int len=1;len<=n;len++){//for every lenth in nums
            for(int i=0;i<=n-len;i++){//for gruping i baloons together
                int j = len+i-1;//end of the group
              
                for(int burst=i;burst<=j;burst++){//assuming only one non burst baloon inside the group i,j and all are burst, all baloons outside this groupp are nonn burst
                    before=0; after=0;
                    mul_left=1; mul_right=1;
                    if(i!=0){
                         mul_left=nums[i-1];
                    }
                    if(j!=n-1){
                        mul_right=nums[j+1];
                    }
                    if(burst!=i){
                        before=dp[i][burst-1];
                    }
                    if(burst!=j){
                        after=dp[burst+1][j];
                    }
                    dp[i][j]= Math.max(dp[i][j],before+ mul_left*nums[burst]*mul_right + after);
                }
            }
        }
        
        return dp[0][n-1];
    }
}
//    2  4  3  5 
//  2 8 30 110 115
//  4 X 24 100 110
//  3 X  X 60  80
//  5 X  X  X  15