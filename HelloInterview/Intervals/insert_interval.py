from typing import List
class Solution:
    def insertIntervals(self, intervals: List[List[int]], newInterval: List[int]):
        merged = []
        for i in range(len(intervals)):
            if newInterval[1] < intervals[i][0]:
                merged.append(newInterval)
                return merged + intervals[i:]
            elif newInterval[0] > intervals[i][1]:
                merged.append(intervals[i])
            else:
                newInterval = [min(newInterval[0], intervals[i][0]), max(newInterval[1], intervals[i][1])]
        merged.append(newInterval)
        return merged
    
intervals = [[1,3],[6,9]]
newInterval = [2,5]
solution = Solution()
result = solution.insertIntervals(intervals, newInterval)
print(result)