from typing import List
class Solution:
    def dailyTemperatures(self, temps: List[int]):
        result = [0] * len(temps)
        stack = []
        for i, t in enumerate(temps):
            while stack and temps[i] > temps[stack[-1]]:
                index = stack.pop()
                result[index] = i - index
            stack.append(i)
        return result
    
solution = Solution()
temps = [65, 70, 68, 60, 55, 75, 80, 74]
output = [1,4,3,2,1,1,0,0]
result = solution.dailyTemperatures(temps)
assert(result == output)