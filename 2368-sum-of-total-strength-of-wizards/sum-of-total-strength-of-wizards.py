class Solution:
    def totalStrength(self, strength: List[int]) -> int:
        MOD = 10**9 + 7
        n = len(strength)
        
        left = [-1] * n
        right = [n] * n
        
        stack = []
        for i in range(n):
            while stack and strength[stack[-1]] >= strength[i]:
                stack.pop()
            left[i] = stack[-1] if stack else -1
            stack.append(i)
            
        stack = []
        for i in range(n - 1, -1, -1):
            while stack and strength[stack[-1]] > strength[i]:
                stack.pop()
            right[i] = stack[-1] if stack else n
            stack.append(i)
            
        presum = [0] * (n + 1)
        for i in range(n):
            presum[i + 1] = (presum[i] + strength[i]) % MOD
            
        ppresum = [0] * (n + 2)
        for i in range(n + 1):
            ppresum[i + 1] = (ppresum[i] + presum[i]) % MOD
            
        ans = 0
        for i in range(n):
            l = left[i]
            r = right[i]
            
            left_count = i - l
            right_count = r - i
            
            right_sum = (ppresum[r + 1] - ppresum[i + 1]) % MOD
            left_sum = (ppresum[i + 1] - ppresum[l + 1]) % MOD
            
            total_sum = (right_sum * left_count - left_sum * right_count) % MOD
            ans = (ans + strength[i] * total_sum) % MOD
            
        return ans