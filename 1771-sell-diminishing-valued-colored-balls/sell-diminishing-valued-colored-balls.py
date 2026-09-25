class Solution:
    def maxProfit(self, inventory: list[int], orders: int) -> int:
        MOD = 10**9 + 7
        
        low, high = 0, max(inventory)
        k = 0
        while low <= high:
            mid = (low + high) // 2
            total_balls = sum(x - mid for x in inventory if x > mid)
            
            if total_balls <= orders:
                k = mid
                high = mid - 1  
            else:
                low = mid + 1   
                
        ans = 0
        sold_count = 0
        
        for x in inventory:
            if x > k:
                count = x - k
                ans += (x + k + 1) * count // 2
                sold_count += count
                
        ans += (orders - sold_count) * k
        
        return ans % MOD