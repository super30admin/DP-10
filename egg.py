class Solution(object):
    def superEggDrop(self, K, N):
        e = K
        f = N
        t= [[0]*(e+1) for _ in range(N+1)]
        for i in range(1,f+1):
            
            for j in range(1,e+1):
                t[i][j] = t[i-1][j]+t[i-1][j-1]   
                t[i][j] = t[i][j] + 1
                
            if t[i][j] >= f:
                return i
                
                
                #tc == o(KN)
                #sc = o(KN)
