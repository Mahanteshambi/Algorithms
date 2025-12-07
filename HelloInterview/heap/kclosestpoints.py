import heapq
import math
from typing import List

class Solution:
    def kClosest(self, points: List[List[int]], k: int):
        dist_heap = []
        for point in points:
            x, y = point
            dist = x*x + y*y
            if len(dist_heap) < k:
                heapq.heappush(dist_heap, (-dist, point))
            elif dist < -dist_heap[0][0]:
                heapq.heappushpop(dist_heap, (-dist, point))
        return [point for d, point in dist_heap[:k]]
    
solution = Solution()
points = [[3,4],[2,2],[1,1],[0,0],[5,5]]
k = 3
assert(solution.kClosest(points, k) == [[0,0], [1,1], [2,2]] or solution.kClosest(points, k) == [[2,2], [0,0],[1,1]])
points = [[3,3],[5,-1],[-2,4]]
k = 2
assert(solution.kClosest(points, k) == [[3,3],[-2,4]] or solution.kClosest(points,k) ==[[-2,4],[3,3]])