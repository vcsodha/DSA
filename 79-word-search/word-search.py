class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows, cols = len(board), len(board[0])
        
        for r in range(rows):
            for c in range(cols):
                if board[r][c] == word[0] and self._dfs(board, word, r, c, 0, rows, cols, set()):
                    return True
                    
        return False

    def _dfs(self, board: List[List[str]], word: str, r: int, c: int, index: int, rows: int, cols: int, visited: set) -> bool:
        if index == len(word):
            return True
        
        if r < 0 or c < 0 or r >= rows or c >= cols or board[r][c] != word[index] or (r, c) in visited:
            return False
        
        visited.add((r, c))
        
        found = (
            self._dfs(board, word, r + 1, c, index + 1, rows, cols, visited) or
            self._dfs(board, word, r - 1, c, index + 1, rows, cols, visited) or
            self._dfs(board, word, r, c + 1, index + 1, rows, cols, visited) or
            self._dfs(board, word, r, c - 1, index + 1, rows, cols, visited)
        )
        
        visited.remove((r, c))
        return found