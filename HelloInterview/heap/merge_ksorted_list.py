from typing import List
from heapq import heappush, heappop

class Solution:
    def mergeKLists(self, lists: List[List[int]]):
        if not lists or len(lists) == 0:
            return []
        heap = []
        for i, node in enumerate(lists):
            if len(node) > 0:
                heappush(heap, (node[0], i, 0))
        if len(heap) == 0:
            return []
        result = []
        while heap:
            val, list_index, i = heappop(heap)
            result.append(val)
            if i+1 < len(lists[list_index]):
                heappush(heap, (lists[list_index][i+1], list_index, i+1))
        return result
    
solution = Solution()
lists = [[3,4,6],[2,3,5],[-1,6]]
assert(solution.mergeKLists(lists) == [-1,2,3,3,4,5,6,6])
lists = [[]]
assert(solution.mergeKLists(lists) == [])