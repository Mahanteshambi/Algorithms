from typing import List

class Solution:
    def surrounded_regions(self, grid: List[List[str]]):
        if not grid:
            return grid
        rows = len(grid)
        cols = len(grid[0])
        
        def dfs(x, y):
            if x >= 0 and y >= 0 and x < rows and y < cols and grid[x][y] == 'O':
                grid[x][y] = 'S'
                dfs(x-1, y)
                dfs(x+1, y)
                dfs(x, y-1)
                dfs(x, y+1)
        for r in range(rows):
            dfs(r, 0)
            dfs(r, cols-1)
        for c in range(cols):
            dfs(0, c)
            dfs(rows - 1, c)
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 'O':
                    grid[r][c] = 'X'
                elif grid[r][c] == 'S':
                    grid[r][c] = 'O'
        return grid
                    
    
solution = Solution()
grid = [
["X","X","X","X","O"],
["X","X","O","X","X"],
["X","X","O","X","O"],
["X","O","X","X","X"],
["X","O","X","X","X"]
]
output = [
["X","X","X","X","O"],
["X","X","X","X","X"],
["X","X","X","X","O"],
["X","O","X","X","X"],
["X","O","X","X","X"]
]
assert(solution.surrounded_regions(grid) == output)