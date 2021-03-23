#Time Complexity:O(nk)
#Space Complexity:O(n)
class Solution:
    def superEggDrop(self, k: int, n: int) -> int: 
        prev = [0] * (k+1)                          #have two arrays of size k+1 that hold the previous floor and current floor attempts
        curr = [0] * (k+1)
        attempts = 0                
        while prev[k] < n:                          #while the previous floor attempt is less than number of eggs
            attempts += 1                           #increment attempt by one
            for i in range(1, k+1):                 #for floors between 1 to k
                curr[i] = 1+prev[i-1]+prev[i]       #update current value using prev values of current and previous floors
            curr, prev = prev, curr                 #update current and previous and return attempt at the end.
        return attempts