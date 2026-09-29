class Solution:

    def hasValidPath(self, grid: list[list[str]]) -> bool:
        m, n = len(grid), len(grid[0])
        if (m + n - 1) % 2 != 0:
            return False

        if grid[0][0] == ")" or grid[m - 1][n - 1] == "(":
            return False

        memo = {}

        def dfs(r: int, c: int, open_count: int) -> bool:
            if open_count < 0:
                return False

            remaining_steps = (m - 1 - r) + (n - 1 - c)

            if open_count > remaining_steps:
                return False

            if r == m - 1 and c == n - 1:
                return open_count == 0

            state = (r, c, open_count)
            if state in memo:
                return memo[state]

            res = False
            for dr, dc in ((1, 0), (0, 1)):
                nr, nc = r + dr, c + dc
                if nr < m and nc < n:
                    delta = 1 if grid[nr][nc] == "(" else -1
                    if dfs(nr, nc, open_count + delta):
                        res = True
                        break

            memo[state] = res
            return res

        return dfs(0, 0, 1)