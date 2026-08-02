class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        for i in range(len(s)):
            # Expand around center for odd-length palindromes (e.g., "aba")
            p1 = self.expand_around_center(s, i, i)
            # Expand around center for even-length palindromes (e.g., "bb")
            p2 = self.expand_around_center(s, i, i + 1)
            
            # Keep the longest result found so far
            res = max(res, p1, p2, key=len)
            
        return res

    def expand_around_center(self, s: str, l: int, r: int) -> str:
        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1
            r += 1
        # The loop ends when s[l] != s[r], so the palindrome is s[l+1 : r]
        return s[l + 1:r]