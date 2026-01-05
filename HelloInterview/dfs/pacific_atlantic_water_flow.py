from typing import List

class Solution:
    def pacific_atlantic_flow(self, grid: List[List[int]]):
        rows, cols = len(grid), len(grid[0])
        pec, alt = set(), set()
        
        def dfs(r, c, visited, prev_height):
            if (r, c) in visited or r <0 or c < 0 or r == rows or c == cols or grid[r][c] < prev_height:
                return
            visited.add((r, c))
            dfs(r+1, c, visited, grid[r][c])
            dfs(r-1, c, visited, grid[r][c])
            dfs(r, c+1, visited, grid[r][c])
            dfs(r, c-1, visited, grid[r][c])
        
        for r in range(rows):
            dfs(r, 0, pec, grid[r][0])
            dfs(r, cols - 1, alt, grid[r][cols - 1])
            
        for c in range(cols):
            dfs(0, c, pec, grid[0][c])
            dfs(rows-1, c, alt, grid[rows-1][c])
        result = []
        for r in range(rows):
            for c in range(cols):
                if (r, c) in pec and (r, c) in alt:
                    result.append([r, c])
                    
        return result

solution = Solution()

grid = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]
output = [
    [0, 2],
    [1, 2],
    [2, 0],
    [2, 1],
    [2, 2]
]
assert(solution.pacific_atlantic_flow(grid) == output)