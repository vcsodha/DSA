import collections

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        graph = collections.defaultdict(list)
        stack = [(root, None)]
        
        while stack:
            node, parent = stack.pop()
            if parent:
                graph[node.val].append(parent.val)
                graph[parent.val].append(node.val)
            if node.left:
                stack.append((node.left, node))
            if node.right:
                stack.append((node.right, node))
        
        min_times = {start: 0}
        stack = [(start, 0)]
        max_time = 0
        
        while stack:
            curr, time = stack.pop()
            max_time = max(max_time, time)
            
            for neighbor in graph[curr]:
                # Revisit only if we found a shorter path
                if neighbor not in min_times or time + 1 < min_times[neighbor]:
                    min_times[neighbor] = time + 1
                    stack.append((neighbor, time + 1))
                    
        return max_time