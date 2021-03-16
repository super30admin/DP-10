class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        #Approach: Backtracking
        #Time Complexity: O(n!)
        #Space Complexity: O(n^2)
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