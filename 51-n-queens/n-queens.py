class Solution:
    def solveNQueens(self, n: int) -> list[list[str]]:
        res = []
        board = [["."] * n for _ in range(n)]
        
        # cols, pos_diag, neg_diag are now integers (bitmasks)
        # Using 0 to represent all unoccupied
        def backtrack(r, cols, pos_diag, neg_diag):
            if r == n:
                res.append(["".join(row) for row in board])
                return
            
            # (1 << n) - 1 creates a bitmask of n ones (e.g., for n=4, 1111)
            # ~(cols | pos_diag | neg_diag) finds all available spots
            available_bits = ((1 << n) - 1) & ~(cols | pos_diag | neg_diag)
            
            while available_bits:
                # Isolate the lowest set bit (the chosen position)
                bit = available_bits & -available_bits
                # Determine column index from the bit
                c = (bit).bit_length() - 1
                
                # Place queen
                board[r][c] = "Q"
                
                # Move to next row with updated masks
                # Shift pos_diag left and neg_diag right to account for row change
                backtrack(r + 1, 
                          cols | bit, 
                          (pos_diag | bit) << 1, 
                          (neg_diag | bit) >> 1)
                
                # Backtrack
                board[r][c] = "."
                # Turn off the bit in available_bits
                available_bits ^= bit
        
        backtrack(0, 0, 0, 0)
        return res