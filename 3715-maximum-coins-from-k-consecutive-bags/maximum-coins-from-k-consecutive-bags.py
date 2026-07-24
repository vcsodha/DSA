class Solution:
    def maximumCoins(self, coins: List[List[int]], k: int) -> int:
        coins.sort()
        n = len(coins)

        prefix_sum = [0] * (n + 1)
        for i in range(n):
            segment_coins = (coins[i][1] - coins[i][0] + 1) * coins[i][2]
            prefix_sum[i + 1] = prefix_sum[i] + segment_coins
            
        def find_first_ge(arr, target):
            low, high = 0, n - 1
            res = n
            while low <= high:
                mid = (low + high) // 2
                if arr[mid] >= target:
                    res = mid
                    high = mid - 1
                else:
                    low = mid + 1
            return res

        def find_last_le(arr, target):
            low, high = 0, n - 1
            res = -1
            while low <= high:
                mid = (low + high) // 2
                if arr[mid] <= target:
                    res = mid
                    low = mid + 1
                else:
                    high = mid - 1
            return res

        ans = 0
        starts = [c[0] for c in coins]
        ends = [c[1] for c in coins]
        
        for l, r, c in coins:
            for ws, we in [(r - k + 1, r), (l, l + k - 1)]:
                idx_start = find_first_ge(ends, ws)
                idx_end = find_last_le(starts, we)
                
                if idx_start <= idx_end:
                    total = prefix_sum[idx_end + 1] - prefix_sum[idx_start]
                    
                    if coins[idx_start][0] < ws:
                        total -= (ws - coins[idx_start][0]) * coins[idx_start][2]
                    
                    if coins[idx_end][1] > we:
                        total -= (coins[idx_end][1] - we) * coins[idx_end][2]
                    
                    ans = max(ans, total)
        
        return ans