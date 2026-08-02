class Solution:
    def longestPalindrome(self, s: str) -> str:
        def get_palindrome_from(l:int,r:int) -> str:
            while l>=0 and r<len(s) and s[l]==s[r]:
                l-=1
                r+=1
            return s[l+1:r]
        res=""
        for i in range(len(s)):
            p1=get_palindrome_from(i,i)
            p2=get_palindrome_from(i,i+1)

            res=max(res,p1,p2,key=len)
        return res