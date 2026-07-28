class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        board = [['.' for _ in range(n)] for _ in range(n)] #empty space
        cols=set()
        next_dia=set() 
        prev_dia=set()

        def backtrack(r):
            if r == n: #if all rows are filled, found valid solution
                copy = ["".join(row) for row in board]
                res.append(copy)
                return
            for c in range(n):
                if c in cols or (r + c) in next_dia or (r - c) in prev_dia:
                    continue
                
                cols.add(c)
                next_dia.add(r + c)
                prev_dia.add(r - c)
                board[r][c] = 'Q'
                
                backtrack(r + 1)
                
                cols.remove(c)
                next_dia.remove(r + c)
                prev_dia.remove(r - c)
                board[r][c] = '.'
                
        backtrack(0)
        return res

