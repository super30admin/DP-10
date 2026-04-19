#TC : O(k*n)
#SC : O(k)
class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        moves = 0
        dp = [0]*(k+1)
        while dp[k]<n:
            moves+=1
            diagUp = 0
            for i in range(1,len(dp)):
                    #   no break    break
                temp = dp[i]
                dp[i] = 1 + dp[i] + diagUp
                diagUp = temp
        
        return moves
                
        
