class Solution:
    #Solution 1
    def maxCoins(self, nums: List[int]) -> int:
        #Approach: Backtracking
        #Time Complexity: O(n^3)
        #Space Complexity: O(n^2)
        #where, n is the length of nums
        
        n = len(nums)
        dp = [[0 for j in range(n)] for i in range(n)]
        
        for length in range(n):                               # window size
            for i in range(n - length):                       # window start index
                j = i + length                                # window end index
                for k in range(i, j + 1):                     # index of last burst in window
                    balloon = nums[k]
                    left = nums[i - 1] if i - 1 >= 0 else 1
                    right = nums[j + 1] if j + 1 < n else 1
                
                    before = dp[i][k - 1] if k != i else 0
                    after = dp[k + 1][j] if k != j else 0
                    
                    dp[i][j] = max(dp[i][j], before + left * balloon * right + after)
        
        return dp[0][-1]
    
    #Solution 2
    """
    def maxCoins(self, nums: List[int]) -> int:
        #Approach: Backtracking
        #Time Complexity: O(n!)
        #Space Complexity: O(1)
        #where, n is the length of nums
        
        self.maxCoins = 0
        self.backtrack(nums, 0)
        return self.maxCoins
    
    def backtrack(self, nums, currCoins):
        #base
        if not nums:
            self.maxCoins = max(self.maxCoins, currCoins)
        
        #logic
        for i in range(len(nums)):
            #action
            newCoins = nums[i] * (nums[i - 1] if i - 1 >= 0 else 1) * (nums[i + 1] if i + 1 < len(nums) else 1)
            popped = nums.pop(i)
            
            #recursion
            self.backtrack(nums, currCoins + newCoins)
            
            #backtrack
            nums.insert(i, popped)
    """