/*
Time Complexity: O(N^3), N^2 to iterate either way of the balloons array and O(N), calculating maximum coins
Space Complexity: O(N*N) memoization array size
Run on leetcode: yes
Any difficulties: no

Approach:
1. Recursion with memoization
2. Attempted after discussed in the class
 */
public class BurstBalloon {
    public static int burstBalloon(int[] balloons){
        return burstBalloonRecursion(balloons, 0, balloons.length-1, new int[balloons.length][balloons.length]);
    }
    public static int burstBalloonRecursion(int[] balloons, int start, int end, int[][] memo){
        if(start>end){
            return 0;
        }
        if(memo[start][end] == 0){
            int left = start>0 ? balloons[start-1] : 1;
            int right = end<balloons.length-1 ? balloons[end+1]:1;

            for(int i = start; i<end; i++){
                memo[start][end] = Math.max(memo[start][end],
                        burstBalloonRecursion(balloons, start, i-1, memo)+left*right*balloons[i]
                        + burstBalloonRecursion(balloons, i+1, end, memo));
            }
        }
        return memo[start][end];
    }
    public static void main(String[] args){
        System.out.println("Maximum coins: "+ burstBalloon(new int[]{3,1,5,8}));
    }
}
