// passes all test cases on leetcode
// 312.
// time - O(n^3)
// space - O(n^2)
class Solution {
    public int maxCoins(int[] nums) {
        //edge
        if(nums == null || nums.length == 0)
        {
            return 0; //empty list
        }
        
        int[][] result = new int[nums.length][nums.length];
        for(int length = 1; length <= nums.length; length++)
        {
            //considering snippets of length 1, 2, 3,...
            for(int start = 0; start <= nums.length - length; start++)
            {
                //start tracks start of current snippet whose length is based on outer for loop
                int end = start + length - 1; //end tracks the end of current snippet
                for(int last = start; last <= end; last++)
                {
                    //we try to burst each baloon from start to end at last and maximize value
                    //left and right tracks which has to be multiplied with last when last is burst
                    //initial values of left, right are 1, this happens when last is at index 0 or n -1
                    int left = 1; 
                    int right = 1;
                    if(start != 0) // for the very first element left is 1 and for others left is previous element
                    {
                        left = nums[start - 1];
                    }
                    if(end != nums.length - 1) // for the last element right is 1 and for others right is next element
                    {
                        right = nums[end + 1];
                    }
                    //before & after track value to be added after last is burst to get value of current snippet, start to end
                    //if current snippet is of length 1, then before and after are 0
                    int before = 0; 
                    int after = 0;
                    if(last != start) //before, after from result[][]
                    {
                        before = result[start][last - 1];
                    }
                    if(last != end)
                    {
                        after = result[last + 1][end];
                    }
                    result[start][end] = Math.max(result[start][end], before + (left * nums[last] * right) + after);
                }
            }
        }
        
        return result[0][result[0].length - 1];
    }
}
