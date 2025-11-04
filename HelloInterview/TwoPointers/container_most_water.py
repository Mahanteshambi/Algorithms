from typing import List
class Solution:
    def max_area(self, heights: List[int]):
        l, r = 0, len(heights)-1
        max_area = 0
        while (l < r):
            width = r-l
            height = min(heights[l], heights[r])
            area = width*height
            max_area = max(area, max_area)
            if heights[l] < heights[r]:
                l+=1
            else:
                r-=1
        return max_area
            

solution = Solution()
heights = [3, 4, 1, 2, 2, 4, 1, 3, 2]
max_area=solution.max_area(heights=heights)
print(max_area)

