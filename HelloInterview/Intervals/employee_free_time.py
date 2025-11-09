from typing import List

class Solution:
    def employeeFreeTime(self, schedule: List[List[List[int]]]):
        schedule = [slot for person_schedule in schedule for slot in person_schedule]
        schedule.sort(key=lambda x: x[0])
        merged = []
        for interval in schedule:
            if not merged or interval[0] > merged[-1][1]:
                merged.append(interval)
            else:
                merged[-1][1] = max(merged[-1][1], interval[1])
                
        free_time = []
        for i in range(1, len(merged)):
            start_time = merged[i-1][1]
            end_time = merged[i][0]
            free_time.append((start_time, end_time))
        return free_time
    
schedule = [[[2,4],[7,10]],[[1,5]],[[6,9]]]
solution = Solution()
result = solution.employeeFreeTime(schedule)
assert(result == [(5,6)])