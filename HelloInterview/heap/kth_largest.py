import heapq
from typing import List

class Solution:
    def kthLargest1(self, nums: List[int], k: int):
        nums_heap = [-x for x in nums]
        heapq.heapify(nums_heap)
        kth_largest = 0
        for i in range(k):
            kth_largest = -heapq.heappop(nums_heap)
        return kth_largest
    
    def kthLargest(self, nums: List[int], k: int):
        if not nums:
            return
        heap = []
        for i in nums:
            if len(heap) < k:
                heapq.heappush(heap, i)
            elif i > heap[0]:
                heapq.heappushpop(heap, i)
        return heap[0]
    
solution = Solution()
nums = [5, 3, 2, 1, 4]
k = 2
assert(solution.kthLargest(nums, k) == 4)