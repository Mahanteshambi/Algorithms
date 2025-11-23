from typing import List
import math

class Solution:
    
    def is_valid_harvest(self, apples, harvest, h):
        total_hours = sum([math.ceil(a/h) for a in apples])
        return total_hours < h
    
    def minHarvestRate(self, apples: List[int], h: int):
        def time_taken(apples, rate):
            time = 0
            for a in apples:
                time += (a + rate - 1) // rate
            return time
        left = 1
        right = max(apples)
        while left < right:
            mid = (left + right) // 2
            if time_taken(apples, mid) > h:
                left = mid + 1
            else:
                right = mid
        return left
            
        
    
solution = Solution()
apples = [3, 6, 7, 11]
h = 8
assert(solution.minHarvestRate(apples=apples, h=h) == 4)