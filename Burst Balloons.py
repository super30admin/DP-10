class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if(nums==None or len(nums)==0):
            return 0
        n=len(nums)
        dp=[[0 for i in range(n)] for i in range(n)]
        