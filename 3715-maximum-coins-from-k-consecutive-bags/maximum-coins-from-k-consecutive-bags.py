class Solution:
    def maximumCoins(self, coins: List[List[int]], k: int) -> int:
        coins.sort()
        n = len(coins)
        ans = 0
        
        curr_coins = 0
        right = 0
        for i in range(n):
            while right < n and coins[right][1] < coins[i][0] + k:
                curr_coins += (coins[right][1] - coins[right][0] + 1) * coins[right][2]
                right += 1
            
            total = curr_coins
            if right < n and coins[right][0] < coins[i][0] + k:
                overlap = min(coins[i][0] + k - 1, coins[right][1]) - coins[right][0] + 1
                total += overlap * coins[right][2]
                
            ans = max(ans, total)
            
            curr_coins -= (coins[i][1] - coins[i][0] + 1) * coins[i][2]
            if right <= i:
                right = i + 1
                curr_coins = 0

        curr_coins = 0
        left = n - 1
        for i in range(n - 1, -1, -1):
            while left >= 0 and coins[left][0] > coins[i][1] - k:
                curr_coins += (coins[left][1] - coins[left][0] + 1) * coins[left][2]
                left -= 1
            
            total = curr_coins
            if left >= 0 and coins[left][1] > coins[i][1] - k:
                overlap = coins[left][1] - max(coins[i][1] - k + 1, coins[left][0]) + 1
                total += overlap * coins[left][2]
                
            ans = max(ans, total)
            curr_coins -= (coins[i][1] - coins[i][0] + 1) * coins[i][2]
            if left >= i:
                left = i - 1
                curr_coins = 0
                
        return ans