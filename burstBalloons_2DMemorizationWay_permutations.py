'''
Time Complexity: 0(n*n*n)
Space Complexity: 0(n*n)
Run on LeetCode: Yes

Approach:
For a particular subproblem, we calculate max of all possible combinations of a particular length,
keeping left max value and right max value as 1 if out of bounds on the corresponding sides.
'''

class Solution:
    
    def memorization2D(self,nums):
        
        # 1. initialize memory2D
        n = len(nums)
        memory2D = [[-1 for col in range(0,n)] for row in range(0,n)]
        
        # 2.1. decide the length of burstibleList
        for length in range(1,n+1):
            # 2.2. decide the starting index of my burstible list
            for startIdx in range(0,(n+1)-length):
                # 2.3. decide the ending index of my burstible list
                endIdx = startIdx+length-1
                # 2.4. now burst the elements in the burstibleList
                for toBurstIdx in range(startIdx,endIdx+1):
                    # fill up memory2D
                    '''do the calculation'''
                    # A. get before value
                    before = 0 # by default
                    if startIdx != toBurstIdx:
                        before = memory2D[startIdx][toBurstIdx-1]
                    
                    # B. cal the bustible coins count
                    left = 1
                    if startIdx != 0:
                        left = nums[startIdx-1]
                    
                    toBurst = nums[toBurstIdx]
                    
                    right = 1
                    if endIdx != n-1:
                        right = nums[endIdx+1]
                    
                    # C. get after value
                    after = 0 # by default
                    if endIdx != toBurstIdx:
                        after = memory2D[toBurstIdx+1][endIdx]
                    
                    calculation = before + (left*toBurst*right) + after
                    # print('Calculations is:\t',calculation)
                    
                    # D. set/update the value in memory2D
                    memory2D[startIdx][endIdx] = max(memory2D[startIdx][endIdx],calculation)
                    
                '''end of burstible list'''
            '''end of current starting pt'''
        '''end of all possible lengths'''
        
        '''
        # print the memory2D
        for r in range(0,n):
            print(memory2D[r])
        '''
        
        # return the result
        return memory2D[0][-1]
    
    def maxCoins(self, nums: List[int]) -> int:
        
        return self.memorization2D(nums)