class Solution:
    def numIslands2(self, m: int, n: int, positions: List[List[int]]) -> List[int]:
        parent = [-1] * (m * n)
        ans = []
        count = 0
        
        def find(i):
            if parent[i] != i:
                parent[i] = find(parent[i])
            return parent[i]
        
        def union(i, j):
            root_i = find(i)
            root_j = find(j)
            if root_i != root_j:
                parent[root_i] = root_j
                return True
            return False

        for r, c in positions:
            index = r * n + c
            
            if parent[index] != -1:
                ans.append(count)
                continue
            
            parent[index] = index
            count += 1
            
            for dr, dc in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                nr, nc = r + dr, c + dc
                neighbor_index = nr * n + nc
                
                if 0 <= nr < m and 0 <= nc < n and parent[neighbor_index] != -1:
                    if union(index, neighbor_index):
                        count -= 1
            
            ans.append(count)
            
        return ans
