class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        curr_sum = 0
        map_sum = {0: 1}
        
        for num in nums:
            curr_sum += num
            
            target = curr_sum - k
            if target in map_sum:
                count += map_sum[target]
            
            map_sum[curr_sum] = map_sum.get(curr_sum, 0) + 1
            
        return count 
