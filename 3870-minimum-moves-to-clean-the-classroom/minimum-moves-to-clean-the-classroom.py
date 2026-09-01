class Solution:
    def minMoves(self, classroom: List[str], energy: int) -> int:
        m, n = len(classroom), len(classroom[0])
        start_x = start_y = -1
        litters = []
        
        for r in range(m):
            for c in range(n):
                cell = classroom[r][c]
                if cell == 'S':
                    start_x, start_y = r, c
                elif cell == 'L':
                    litters.append((r, c))
                    
        num_litters = len(litters)
        full_mask = (1 << num_litters) - 1
        
        litter_map = {pos: i for i, pos in enumerate(litters)}
        
        initial_mask = 0
        if (start_x, start_y) in litter_map:
            initial_mask |= (1 << litter_map[(start_x, start_y)])
            
        if initial_mask == full_mask:
            return 0

        best_energy = [[[-1] * (1 << num_litters) for _ in range(n)] for _ in range(m)]
        
        queue = deque([(start_x, start_y, initial_mask, energy, 0)])
        best_energy[start_x][start_y][initial_mask] = energy
        
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        
        while queue:
            r, c, mask, e, steps = queue.popleft()
            
            if e < best_energy[r][c][mask]:
                continue
                
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                
                if 0 <= nr < m and 0 <= nc < n and classroom[nr][nc] != 'X':
                    ne = e - 1
                    if ne < 0:
                        continue  
                    
                    cell = classroom[nr][nc]
                    nmask = mask
                    
                    if cell == 'L' and (nr, nc) in litter_map:
                        nmask |= (1 << litter_map[(nr, nc)])
                    
                    if nmask == full_mask:
                        return steps + 1
                    
                    if cell == 'R':
                        ne = energy

                    if ne > best_energy[nr][nc][nmask]:
                        best_energy[nr][nc][nmask] = ne
                        queue.append((nr, nc, nmask, ne, steps + 1))
                        
        return -1