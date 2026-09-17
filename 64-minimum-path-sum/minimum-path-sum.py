class Solution:
    def minPathSum(self, grid: list[list[int]]) -> int:
        m,n = len(grid) , len(grid[0])

        @cache
        def sum(r:int, c:int) ->int:
            if r>=m or c>=n:
                return float('inf')

            if r ==m-1 and c==n-1:
                return grid[r][c]
            
            return grid[r][c] + min(sum(r+1,c) , sum(r,c+1))

        return sum(0,0)

