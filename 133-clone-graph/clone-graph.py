"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
            
        cloned = {}

        def dfs(curr: 'Node') -> 'Node':
            if curr in cloned:
                return cloned[curr]
            
            # Create node clone and store in mapping
            copy = Node(curr.val)
            cloned[curr] = copy
            
            # Recursively copy and attach neighbors
            for neighbor in curr.neighbors:
                copy.neighbors.append(dfs(neighbor))
                
            return copy

        return dfs(node)
        