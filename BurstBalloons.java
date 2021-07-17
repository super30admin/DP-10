public class BurstBalloons {

    
    //It can not divide into sub problems as it is depend on other values.
    // So , we need to burst the current baloon at the end to make them independent subproblems.
    
    //Gap statergy - Starting the smallest sub problem and gradually increased it.
    //If we burst baloon 1 only, 2 only, 3 only and so on.
    //Then combination of 2 balloons.
    //Then combination of 3 balloons and so on.
    
    // We need to form differnt pairs starting length 1 to n
    // (1),(2),(3),(4)
    // (1,2),(2,3),(3,4)
    // (1,2,3),(2,3,4)
    // (1,2,3,4)
    
    //In order form the pair we need, first for loop with the window  -- 1 to <=n
    //Second with how many combinations. 0 to <= n-window size
    
    
    //Then form the pair with another for loop till pair iteration + window size -1
    
    // Before + (left * right) + after
    //Before and after are sub problems. - We just need to get it from the dp matrix as the diagnal elements are already filled
    //left  is left element before it and right is right element after that.
    
    //TC: O(N^3) each window , each pair and each balloon 
    //SC: O(N) where n is lenght of the balloons
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        
        int[][] dp = new int[n][n]; // 4 - 0,1,2,3
        
        for(int windowLength = 1; windowLength <= n;windowLength++) { //Each Window 
            for(int i = 0;i<=n-windowLength;i++) { // How many combinations
                int j = i+windowLength-1;
                int max = 0;
                for(int k=i;k<=j;k++) { // Each combination
                    // Before + (left * right) + after
                    int before = 0;
                    int after = 0;
                    if(k != i) { //If it is starting index so we don't need to find the value it will be zero
                        before = dp[i][k-1];             
                    }
                    
                    if(k != j) {
                        after = dp[k+1][j];
                    }
                    
                    int left = 1; //Padding
                    int right = 1; //Padding
                    
                    if(i != 0) {
                        left = nums[i-1];
                    }
                    
                    if(j != n-1) {
                        right = nums[j+1];
                    }
                    
                    
                    int lastBurst = nums[k];
                    int currentEarnings = left * lastBurst * right;
                    max = Math.max(max, before + currentEarnings + after);
                }
                
                dp[i][j] = max;
            }
        }
        return dp[0][n-1];
   }

    public static void main(String[] args) {
        BurstBalloons burstBalloons = new BurstBalloons();
        int result = burstBalloons.maxCoins(new int[] { 3,1,5,8 });
        System.out.println("The result: "+ result);
    }
}