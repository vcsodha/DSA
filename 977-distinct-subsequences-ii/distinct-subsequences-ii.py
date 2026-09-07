class Solution:
    def distinctSubseqII(self, s: str) -> int:
        MOD = 10 ** 9 +7
        last_seen={}
        dp=[0] * (len(s) +1)
        dp[0]=1

        for i,char in enumerate(s,1):
            dp[i] = (dp[i-1] * 2) % MOD

            if char in last_seen:
                prev=last_seen[char]
                dp[i] = (dp[i] - dp[prev-1] + MOD)
            
            last_seen[char] = i
        return (dp[-1] - 1 + MOD) % MOD