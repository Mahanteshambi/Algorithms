from typing import List
from collections import deque

class Solution:
    def rotting_oranges(self, grid: List[List[str]]):
        if not grid:
            return -1
        queue = deque()
        fruites = 0
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == 'R':
                    queue.append((r, c))
                elif grid[r][c] == 'F':
                    fruites+=1
        directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        minutes = 0
        while queue and fruites > 0:
            minutes+=1
            for i in range(len(queue)):
                cur_x, cur_y = queue.popleft()
                for move_x, move_y in directions:
                    next_x = cur_x + move_x
                    next_y = cur_y + move_y
                    if next_x >=0 and next_x < len(grid) and \
                        next_y >=0 and next_y < len(grid[0]) and \
                            grid[next_x][next_y] == 'F':
                                grid[next_x][next_y] = 'R'
                                queue.append((next_x, next_y))
                                fruites-=1
        return minutes if fruites == 0 else -1
    
solution = Solution()
grid = [['R','F'],['F','F']]
assert(solution.rotting_oranges(grid) == 2)
grid = [
["R", "F", "F", "F"],
["F", "F", "F", "R"],
["E", "E", "F", "F"],
]
assert(solution.rotting_oranges(grid) == 2)
