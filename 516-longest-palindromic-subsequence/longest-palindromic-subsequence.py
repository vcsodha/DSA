class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        @cache
        def solve(i:int, j:int) ->int:
            if i>j:
                return 0
            if i==j:
                return 1
            if s[i] == s[j]:
                return 2+ solve(i+1,j-1)
            
            option1=solve(i+1,j)
            option2=solve(i,j-1)

            return max(option1,option2)
        
        return solve(0,len(s)-1)