from typing import List
import heapq

class Solution:
    def kClosest(self, nums: List[int], k: int, target: int):
        heap = []
        for i in nums:
            dist = abs(i - target)
            if len(heap) < k:
                heapq.heappush(heap, (-dist, i))
            elif dist < -heap[0][0]:
                heapq.heappushpop(heap, (-dist, i))
            
        result = [num for dist, num in heap]
        result.sort()
        return result
        
    
solution = Solution()
nums = [-1, 0, 1, 4, 6]
target = 1
k = 3
assert(solution.kClosest(nums, k, target) == [-1, 0, 1])