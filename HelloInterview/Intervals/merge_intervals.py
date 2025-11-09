from typing import List

class Solution:
    def mergeIntervals(self, intervals: List[List[int]]):
        intervals.sort(key=lambda x:x[0])
        merged = []
        for interval in intervals:
            if not merged or interval[0] > merged[-1][1]:
                merged.append(interval)
            else:
                merged[-1][1] = max(merged[-1][1], interval[1])

        return merged
solution = Solution()
intervals = [[3,5],[1,4],[7,9],[6,8]]
result = solution.mergeIntervals(intervals)
assert (result == [[1,5],[6,9]])