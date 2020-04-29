// Time Complexity : O(k*n) number of floors and number of eggs 
// Space Complexity : O(K*n) number of floors and eggs
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach
class Solution {
    public int superEggDrop(int K, int N) {
        
        int[][] floors = new int[N+1][K+1];
        
        for(int attempts = 1; attempts <= N; attempts++){
            for(int eggs = 1; eggs<=K; eggs++){
                floors[attempts][eggs] = 1 + floors[attempts-1][eggs] + 
                                            floors[attempts-1][eggs-1];
            if(floors[attempts][eggs] >= N)
                return attempts;
            }
        }
        
        return N;
        
//         // K eggs and N Floors
//         int[][] attempts = new int[K+1][N+1];
        
//         // if there is 1 egg then attempts will be no of floors.
//         for(int floor = 1; floor<=N; floor++){
//             attempts[1][floor] = floor;
//         }
        
//         for(int eggs=2; eggs<=K;eggs++){
//             for(int n = 1; n<=N;n++){
//             attempts[eggs][n] = Integer.MAX_VALUE;
//             for(int floor = 1; floor <= N; floor++){
//                 attempts[eggs][n] = Math.min(attempts[eggs][n] , 
//                     1 + Math.max(attempts[eggs-1][floor-1],
//                                     attempts[eggs][N - floor]));
//             }    
//             }
            
//         }
//         return attempts[K][N];
    }
}
