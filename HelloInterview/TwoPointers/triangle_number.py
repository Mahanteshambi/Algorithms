from typing import List

class Solution:
    def triangleNumber(self, heights: List[int]):
        heights.sort()
        count = 0
        for i in range(len(heights) - 1, 1, -1):
            l, r = 0, i - 1
            while l < r:
                if heights[l] + heights[r] > heights[i]:
                    count += r - l
                    r-=1 
                else:
                    l+=1
        return count
    
heights = [11,4,9,6,15,18]
solution = Solution()
count = solution.triangleNumber(heights=heights)