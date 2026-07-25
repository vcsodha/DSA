class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if not intervals:
            return []
            
        intervals.sort()
        res = []
        res.append(intervals[0])
        
        for i in range(1, len(intervals)):
            last = res[-1]
            curr = intervals[i]

            if curr[0] <= last[1]:
                last[1] = max(last[1], curr[1])
            else:
                res.append(curr)
                
        return res