class Problem2 {
    public int maxCoins(int[] nums) {
        
        int n= nums.length;
        int dp[][]= new int[n][n];
        
        for( int size=1;size<=n;size++){
            
            for( int start=0;start<=n-size; start++){
                
                int end=start+size-1;
              
              
                
                for(int lastburst = start; lastburst<=end;lastburst++){
                     // System.out.println(start+" * "+ end);
                int leftsum=0;
                int rightsum=0;
                int leftprod=1;
                int rightprod=1;
                    if(lastburst!=start){
                        
                        leftsum=dp[start][lastburst-1];
                    }
                    if(lastburst!=end){
                        
                        
                        rightsum=dp[lastburst+1][end];
                    }
                    
                    if(start!=0){
                        
                         leftprod= nums[start-1];
                    }
                    if(end!=n-1){
                        
                        rightprod= nums[end+1];
                    }
                    
                    dp[start][end]=Math.max(dp[start][end],leftsum+(leftprod*nums[lastburst]*rightprod)+rightsum);
                    
                    
                }
                
                
                
            }
            
            
            
        }
        
        
     
        return dp[0][n-1];
        
        
        
    }
}