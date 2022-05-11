/*
Time Complexity: O(klongn), k is the number of eggs and n is the the steps
Space Complexity: O(nk)
Run on leetcode: Yes
Any difficulties: no

Approach:
1. if egg breaks, then let's go to a floor down check dp[count - 1][k - 1],
2. otherwise we can check dp[count - 1][k] floor.
3. Attempted once discussed in the class
 */
public class SuperEggDrop {
    public static int superEggDrop(int k, int n){
        int[][] dp = new int[n+1][k+1];
        int count = 0;

        while (dp[count][k]< n){
            count++;
            for(int i = 1; i<=k; i++){
                dp[count][k] = dp[count-1][k-1]+dp[count-1][k]+1;
            }
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println("Super Egg Drop: "+ superEggDrop(1, 2));
    }
}
