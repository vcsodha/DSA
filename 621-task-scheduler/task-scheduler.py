class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        # 1. Count frequencies of each task
        counts = {}
        for task in tasks:
            counts[task] = counts.get(task, 0) + 1
            
        # 2. Find max frequency and how many tasks have that frequency
        max_freq = 0
        for count in counts.values():
            max_freq = max(max_freq, count)
            
        max_tasks_count = 0
        for count in counts.values():
            if count == max_freq:
                max_tasks_count += 1
                
        # 3. Calculate minimum intervals
        # (max_freq - 1) full cycles of length (n + 1)
        # plus the number of tasks that have the max frequency
        res = (max_freq - 1) * (n + 1) + max_tasks_count
        
        # 4. Result is either the calculated frame or the total number of tasks
        return max(res, len(tasks))