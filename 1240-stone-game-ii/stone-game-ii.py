class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        n=len(piles)
        suf_sum=[0] * (n+1)
        for i in range(n-1,-1,-1):
            suf_sum[i] = suf_sum[i+1] + piles[i]

        memo={}
        def dp(i:int, m:int) -> int:
            if i+2*m>=n:
                return suf_sum[i]
            
            if(i,m) in memo:
                return memo[(i,m)]
            
            max_stones=0

            for x in range(1,2*m+1):
                stones=suf_sum[i] - dp(i+x, max(m,x))
                max_stones=max(max_stones,stones)
            
            memo[(i,m)] = max_stones
            return max_stones

        return dp(0,1)