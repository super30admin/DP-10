Time Complexity = O(K*N)
Space Complexity = O(N)

class Solution {
    public int superEggDrop(int K, int N) {
        int[][]floors = new int[N+1][K+1];
        
        for(int attempt = 1; attempt <= N; attempt++){
            for(int k = 1; k <=K;k++){
                floors[attempt][k] = 1 + floors[attempt - 1][k-1] + floors[attempt - 1][k];
                
                if(floors[attempt][k] >= N)return attempt;
            }
        }
        return N;
    }
}