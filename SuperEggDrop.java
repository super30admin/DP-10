//TC will be O(kn)
//SC will be O(kn)

class SuperEggDrop {
    public int superEggDrop(int k, int n) {
        if(k == 0 || n == 0){
            return 0;
        }

        int[][] dp = new int[n +1][k + 1];
        int attempts = 0;

        while(dp[attempts][k] < n){
            attempts++;
            for(int j =1; j < k + 1; j++){
                dp[attempts][j] = 1 + (dp[attempts - 1][j -1] + dp[attempts - 1][j] );
            }

        }
        return attempts;
    }

    public static void main(String[] args){
        SuperEggDrop obj = new SuperEggDrop();
        int k = 1, n = 2;
        System.out.println(obj.superEggDrop(k,n));
    }
}