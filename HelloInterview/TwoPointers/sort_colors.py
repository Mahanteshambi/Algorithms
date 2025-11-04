from typing import List

class Solution:
    def sortColors(self, nums: List[int]):
        i, l, r = 0, 0, len(nums)-1
        while i < r:
            if nums[i] == 0:
                nums[i], nums[l] = nums[l], nums[i]
                l+=1
                i+=1
            elif nums[i] == 1:
                i+=1
            elif nums[i] == 2:
                nums[i], nums[r] = nums[r], nums[i]
                r-=1
        return nums
    
solution = Solution()
nums = [2,0,2,1,1,0]
result = solution.sortColors(nums=nums)
print(result)