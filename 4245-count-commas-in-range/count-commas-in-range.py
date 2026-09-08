class Solution:
    def countCommas(self, n: int) -> int:
        ans=0
        start=1000
        commas=1

        while start<=n:
            next_start=start * 1000
            count = min(n,next_start -1) - start +1
            ans += count * commas
            start = next_start
            commas +=1
        
        return ans