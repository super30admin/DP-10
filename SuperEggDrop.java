class SuperEggDrop{
 //Time complexity - O(2^n)
    // space complexity - O(n)
    // TLE

    //Driver function 
    public int superEggDrop(int K, int N) {
        return helper(K,N);
    }
    
    //Helper function 
    private int helper(int egg, int n){
        //base case
        if(egg == 1)
            return n;
        if(n <= 1)
            return n;
        int max = Integer.MAX_VALUE;

        // for each floor there will be two condition either egg will break or not 
        // if break then number of egg will be reduced by 1 and number of floor will i-1
        // if egg will nit break then total number of floor will be N-i
        for(int i=1;i<=n; i++){
            int ebreak = helper(egg-1,i-1);
            int notbreak = helper(egg,n-i);
            max = Math.min(Math.max(ebreak,notbreak)+1,max);
        }
        return max;
    }
}