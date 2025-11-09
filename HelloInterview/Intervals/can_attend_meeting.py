from typing import List

class Solution:
    def canAttendMeetings(self, intervals: List[List[int]]):
        intervals.sort(key=lambda x: x[0])
        for i in range(1, len(intervals)):
            if intervals[i-1][1] > intervals[i][0]:
                return False
        return True
    
intervals = [(10,12),(6,9),(13,15)]
solution = Solution()
result = solution.canAttendMeetings(intervals=intervals)
print(result)