class Problem1 {
    public int superEggDrop(int k, int n) {
        int moves=n+1;
        int eggs=k+1;
       int dp[][]= new int[moves+1][k+1];
        
        for( int i=0;i<eggs;i++){
            
            dp[0][i]=0;
        }
        for( int j=0;j<moves;j++){
            
            
            dp[j][0]=0;
            
        }
        
        
        for( int i=1;i<moves;i++){
            
            for(int j=1;j<eggs;j++){
                
                int broken= dp[i-1][j-1];
                int not_broken= dp[i-1][j];
                
                dp[i][j]=1+broken+not_broken;
                
                if(dp[i][j]>=n){return i; }
            }
            
        }
        
        
        return n;
        
        
    }
}