from typing import List

class Solution:
    def moveZeroes(self, nums: List[int]):
        non_zero_index = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[i], nums[non_zero_index]= nums[non_zero_index], nums[i]
                non_zero_index+=1
        return nums         

nums = [2,0,4,0,9]    
solution = Solution()
result = solution.moveZeroes(nums)
print(result)