class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        # 1. Add the new interval to the list
        intervals.append(newInterval)
        
        # 2. Sort based on the start time (first element of each sub-list)
        # This takes O(n log n) time
        intervals.sort(key=lambda x: x[0])
        
        # 3. Use your existing Merge Intervals logic to combine overlaps
        res = [intervals[0]]
        
        for i in range(1, len(intervals)):
            last = res[-1]
            curr = intervals[i]
            
            # If they overlap, merge them
            if curr[0] <= last[1]:
                last[1] = max(last[1], curr[1])
            else:
                # No overlap, add as a new interval
                res.append(curr)
                
        return res