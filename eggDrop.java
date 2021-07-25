// Time Complexity : O(NK)
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int superEggDrop(int k, int n) {
        if(n == 0 || k == 0) return 0;
        if(k == 1) return n;
        int[] prev = new int[k+1];
        int[] curr = new int[k+1];
        for(int j = 1 ; j < k + 1 ; j++) prev[j] = 1;
        for(int i = 2 ; i < n+1 ; i++){
            for(int j = 1 ; j < k+1 ; j++){
                curr[j] = 1 + prev[j]+prev[j-1];
                //System.out.println(i+" "+j+" "+curr[j]);
                if(curr[j] >= n) return i;
            }
            prev = Arrays.copyOf(curr,curr.length);
        }
        return 1;
        
    }
}