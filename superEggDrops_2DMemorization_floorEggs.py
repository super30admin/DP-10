'''
solution: dp of floors and eggs
Time Complexity: 0(m*n*k)
                m: number of eggs
                n: number of floors
                k: iterate each floor  till n
Space Complexity: 0(m*n)
Approach:
    Semi optimal soultion using DP would be for N floors and K eggs, where you consider one of 
    two options when egg is dropped from ith floor, either egg is broken or not broken.
    A. If broken => consider the cell [K-1, i-1] meaning try K-1 eggs for i-1 below floors
    B. If non broken => consider cell [K, N-i] meaning try K egg in any of the above N-i floors
    
    As 1 move is completed => 1 + max(broken, non-broken) => 
    1 + max(cell[K-1, i-1], cell[K, N-i]) for cell[K, N]
'''
class Solution:
    
    def memorization2D(self,eggs,floors):
        
        # 1. initialize no of rows and no of cols
        '''
            eggs signifies row 
            floors signifies columns
        '''
        rows = eggs+1
        cols = floors+1
        memory2D = [[0 for j in range(0,cols)] for i in range(0,rows)]
        
        
        # 2. fill-up memory2D
        # fill-up the row 1 with values
        for j in range(1,cols):
            memory2D[1][j] = j
        '''
        start from i (i.e. row) = 2 and j (i.e. col) =1
        '''
        for i in range(2,rows):
            for j in range(1,cols):
                memory2D[i][j] = float('inf')
                for f in range(1,j+1):
                    # f signifies floor
                    # egg breaks
                    egg_break = memory2D[i-1][f-1]
                    # egg doesnt break
                    egg_no_break = memory2D[i][j-f]
                    # calculate the move
                    calculate = 1 + max(egg_break,egg_no_break)
                    # update the memory2D
                    memory2D[i][j] = min(memory2D[i][j],calculate)
                '''end of floor possibilities check'''
            '''end of floor'''
        '''end of eggs possibilities with floors check'''
        
        '''
        # print memory2D
        print("\nSTART")
        for i in range(0,rows):
            print(memory2D[i])
        print("END\n")
        '''
        return memory2D[-1][-1]
    
    def superEggDrop(self, k: int, n: int) -> int:
        # eggs = k, 4
        # floors = n, 4
        return self.memorization2D(k,n)