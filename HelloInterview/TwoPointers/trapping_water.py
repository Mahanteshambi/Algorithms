from typing import List

class Solution:
    def trappingWater(self, height: List[int]):
        if len(height) == 0:
            return 0
        left, right = 0, len(height) -1
        left_max, right_max = height[left], height[right]
        count = 0
        while left <= right:
            if left_max < right_max:
                if height[left] > left_max:
                    left_max = height[left]
                else:
                    count += left_max - height[left]
                left+=1
            else:
                if height[right] > right_max:
                    right_max = height[right]
                else:
                    count += right_max - height[right]
                right-=1
        return count
    
solution = Solution()
height = [3, 4, 1, 2, 2, 5, 1, 0, 2]
result = solution.trappingWater(height=height)
print(result)