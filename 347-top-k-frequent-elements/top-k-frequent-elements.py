class Solution:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        unique_elements = list(set(nums))
        freq_list = []
        
        for i in unique_elements:
            count = 0
            for j in nums:
                if i == j:
                    count += 1
            freq_list.append([i, count])
        
        freq_list.sort(key=lambda x: x[1], reverse=True)
        
        result = []
        for i in range(k):
            result.append(freq_list[i][0])
            
        return result