class Solution {
    
    //Time Complexity: O(n*n*n)
    //Space Complexity: O(n*n)
    
    public int maxCoins(int[] nums) {
        
        if(nums == null || nums.length == 0){                                               //check for null case
            return 0;
        }
        
        int n = nums.length;                                                                //take the length
        int dp[][] = new int[n][n];                                                         //create a dp array which helps to store the value by bursting the ballons
        
        for(int len = 1; len <= n; len++){                                                  //iterate till len reaches to n => here we are taking 1 len at first and then increament it and iterate the loop till len reaches to the length of array, here len means that are ballons are available to burst, so we are solving smaller sub-problems first and then by helping those results we will solving the bigger problem
            
            for(int start = 0; start <= n-len; start++){                                    //iterate till start reaches to n-len, start means start pointer of the ballons which are available to burst
                
                int end = start + len - 1;                                                  //end pointer od the ballons which are available to burst
                int max = Integer.MIN_VALUE;                                                //take max and store min value
                
                for(int current = start ; current<=end; current++){                             //iterate till current reaches to the end, here we are taking one ballon at a time from the available ballons, and we are considering that ballon is bursting at the end
                    
                    //current means the index at array where ballon is bursted at the last
                    int leftValue = 1;                                                      //give the leftValue by 1, leftValue is the left value of the current bursting ballon
                    int rightValue = 1;                                                     //give the rightValue by 1, rightValue is the right value of the current bursing ballon
                    
                    if(start != 0){                                                         //check if start is pointing to the 0 index
                        leftValue = nums[start-1];                                          //if not, then update the leftValue
                    }
                    if(end != n-1){                                                         //check if the end is pointing to the end of an array
                        rightValue = nums[end+1];                                           //if not, then update the rightValue
                    }
                    
                    int currentPart = leftValue * nums[current] * rightValue;               //left * current * right
                    
                    int leftPartBefore = 0;                                                 //leftPartBefore means the values of the ballons which are left side of the current bursting ballon
                    int rightPartBefore = 0;                                                //rightPartBefore means the values of the ballons which are right side of the current bursting ballon
                    
                    if(current!=start){                                                     //check if current is not pointing to the start index
                        leftPartBefore = dp[start][current-1];                              //if not, then update the leftPartBefore value
                    }
                    
                    if(current!=end){                                                       //check if the current is not point to the end index
                        rightPartBefore = dp[current+1][end];                               //if not, then update the rightPartBefore value
                    }
                    
                    max = Math.max(max, leftPartBefore + currentPart + rightPartBefore);        //take the max between earlier max and leftPartBefore + currentPart + rightPartBefore
            
                }
                dp[start][end] = max;                                                       //store the max value in the dp
            }
        }
        return dp[0][n-1];                                                                  //return the result
    }
    


//     public int maxCoins(int[] nums) {
        
//         if(nums.length == 0){
//             return 0;
//         }
//         int len = nums.length;
        
//         int[][] dp = new int[len][len];
        
//         for(int n=0; n<len; n++){
            
//             for(int i=0; i+n<len; i++){
                
//                 int j = i+n;
                
//                 for(int k =i; k<=j; k++){
                    
//                     int leftNum = i==0?1 : nums[i-1];
//                     int rightNum = j==len-1?1: nums[j+1];
                    
//                     int left = k==i?0: dp[i][k-1];
//                     int right = k==j?0:dp[k+1][j];
                    
//                     dp[i][j] = Math.max(dp[i][j], leftNum*nums[k]*rightNum + left + right);
                    
//                 }
                
//             }
            
//         }
        
//         return dp[0][len-1];
        
//     }
    
    
    
//         0 1 2 3
// nums = [3,1,5,8]

// func(0,3) => max(
        
//             1*3*1 + func(1,3),
//             1*1*1 + func(0, 0) + func(2,3),
//             1*5*1 + func(0, 1) + func(3,3)
//             1*8*1 + func(0, 2)
            
//         )
            
//         0 1 2 3
// nums = [3,1,5,8]
//           |   |
//           i   j
            
// func(1,3) => max(
        
//         3*1*1 + func(2, 3),
//         3*5*1 + func(1, 1) + func(3, 3)
//         3*8*1 + func(1, 2)
        
//         )
// So, formula is 
// for( k from i to j){
//     max( 
//         nums[i-1] * nums[k] * nums[j+1] + dp[i][k-1] + dp[k+1][j]
//     )
// }
}
