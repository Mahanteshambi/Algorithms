from typing import List

class Solution:
    def number_of_islands(self, grid: List[List[int]]):
        no_of_islands = 0
        rows = len(grid)
        cols = len(grid[0])
        def dfs(r, c):
            grid[r][c] = 0
            if r > 0 and grid[r -1][c] == 1:
                return dfs(r-1, c)
            if r < rows - 1 and grid[r+1][c] == 1:
                return dfs(r+1, c)
            if c > 0 and grid[r][c- 1] ==1:
                return dfs(r, c-1)
            if c < cols - 1 and grid[r][c+1] == 1:
                return dfs(r, c+1)
            
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c]:
                    dfs(r, c)
                    no_of_islands+=1
        return no_of_islands
            
    
solution = Solution()
grid = [
[1,1,0,1],
[1,1,0,1],
[1,1,0,0],
]
assert(solution.number_of_islands(grid) == 2)