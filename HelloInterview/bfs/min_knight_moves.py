from collections import deque
class Solution:
    def minimum_knight_moves(self, x: int, y: int):
        queue = deque([(0, 0, 0)])
        visited = set([(0, 0)])
        directions = [(2, 1),(2, -1), (-2, 1), (-2, -1),
                      (1, 2), (1, -2), (-1, 2), (-1, -2)]
        while queue:
            curr_x, curr_y, moves = queue.popleft()
            if curr_x == x and curr_y == y:
                return moves
            for move_x, move_y in directions:
                next_x = curr_x + move_x
                next_y = curr_y + move_y
                if (next_x, next_y) not in visited:
                    visited.add((next_x, next_y))
                    queue.append((next_x, next_y, moves + 1))
        return -1
    
solution = Solution()
x = 4
y = 4
assert(solution.minimum_knight_moves(x, y) == 4)