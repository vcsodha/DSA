class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count=Counter(nums)
        min_heap=[]
        for num,freq in count.items():
            heapq.heappush(min_heap,(freq,num))

            if len(min_heap) >k:
                heapq.heappop(min_heap)
        return [pair[1] for pair in min_heap]
