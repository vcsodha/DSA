class Solution:
    def numWays(self, n: int, k: int) -> int:
        if n == 1:
            return k
        if n == 2:
            return k * k
        
        prev2 = k
        prev1 = k * k
        
        for _ in range(3, n + 1):
            current = (prev1 + prev2) * (k - 1)
            
            prev2 = prev1
            prev1 = current
            
        return prev1