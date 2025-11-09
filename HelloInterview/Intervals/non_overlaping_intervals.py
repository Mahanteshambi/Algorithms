from typing import List

class Solution:
    def nonOverlappingIntervals(self, intervals: List[List[int]]):
        count = 1
        intervals.sort(key=lambda x: x[1])
        end = intervals[0][1]
        for i in range(1, len(intervals)):
            if end <= intervals[i][0]:
                end = intervals[i][1]
                count+=1
        return len(intervals) - count

intervals = [[1,2],[2,3],[3,4],[1,3]]
solution = Solution()
result = solution.nonOverlappingIntervals(intervals)
print(result)