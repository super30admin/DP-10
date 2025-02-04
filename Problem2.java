class Solution {
    public int maxCoins(int[] nums) {

        int[][] dp = new int[nums.length][nums.length];
        int n = nums.length;


        int i = 0;
        int j = 0;
        int d = 0; 

        while(d<n){
            
                if(true){
                    int value = Integer.MIN_VALUE;
                    for(int k=i;k<=j;k++){

                        int left = (((k-1) >=0) ? dp[i][k-1] : 0);
                        int right = (((k+1) <= j) ? dp[k+1][j] : 0);
                        int lmid = ((i==k) ? (((i-1)>=0)? nums[k-1] : 1)    : (((i-1)>=0)? nums[i-1] : 1)   );
                        int rmid = (((k==j)? (((k+1)<n)? nums[k+1] : 1)  : (((j+1)<n)? nums[j+1] : 1) ));
                        int mid =  lmid    *nums[k]* rmid       ;
                        int temp = left  + mid  + right;

                        if(i==0 && j==2){
                            System.out.println("i = "+i+" j = "+j+" k = "+k+" left = " + left + ", right = " + right + ", lmid = " + lmid + ", rmid = " + rmid + ", mid = " + mid + ", temp = " + temp);

                        }


                    value = Math.max(value,temp);
                    }
                    dp[i][j] = value;
                }

            i++;
            j++;
            if(i>=n || j>=n){
                d++;
                i=0;
                j=d;
            }

            
        }

        return dp[0][n-1];


        
    }

 
}