from typing import List
from collections import deque

class Solution:
    def updateMatrix(self, mat: List[List[int]]):
        if not mat:
            return -1
        queue = deque()
        count = 0
        directions = [[0,1],[1,0],[0,-1],[-1,0]]
        rows, cols = len(mat), len(mat[0])
        output = [[-1] * cols for _ in range(rows)]
        for r in range(rows):
            for c in range(cols):
                if mat[r][c] == 0:
                    queue.append((r, c))
                    output[r][c] = 0

        while queue:
            count+=1
            for i in range(len(queue)):
                x, y = queue.popleft()
                for dx, dy in directions:
                    nx = x + dx
                    ny = y + dy
                    if 0 <= nx < rows and 0 <= ny < cols:
                        if output[nx][ny] == -1:
                            output[nx][ny] = count
                            queue.append((nx, ny))
        return output
    
solution = Solution()
mat = [[1,1,1],[1,1,1],[1,1,1]]
output = [[-1,-1,-1],[-1,-1,-1],[-1,-1,-1]]
assert(solution.updateMatrix(mat=mat) == output)
mat = [
  [1, 0, 1],
  [0, 1, 0],
  [1, 1, 1],
]
output = [
  [1, 0, 1],
  [0, 1, 0],
  [1, 2, 1],
]
assert(solution.updateMatrix(mat=mat)==output)