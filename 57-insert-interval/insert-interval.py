class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res = []
        i = 0
        n = len(intervals)
        
        # 1. Add all intervals that end before the newInterval starts
        while i < n and intervals[i][1] < newInterval[0]:
            res.append(intervals[i])
            i += 1
            
        # 2. Merge all overlapping intervals with newInterval
        # If they overlap, update newInterval's boundaries
        while i < n and intervals[i][0] <= newInterval[1]:
            
            if intervals[i][0] < newInterval[0]:
                newInterval[0] = intervals[i][0]
            
            if intervals[i][1] > newInterval[1]:
                newInterval[1] = intervals[i][1]
            i += 1
            
        # Add the merged interval
        res.append(newInterval)
        
        # 3. Add all remaining intervals that start after newInterval ends
        while i < n:
            res.append(intervals[i])
            i += 1
            
        return res