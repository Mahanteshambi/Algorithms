from typing import List
class Solution:
    def twoSum(self, nums: List[int], target: int):
        l, r = 0, len(nums) - 1
        while l < r:
            sum = nums[l] + nums[r]
            if sum == target:
                return True
            if sum < target:
               l+=1
            else:
                r-=1
        return False 
    
solution = Solution()
nums = [1,3,4,6,8,10,13]
print(solution.twoSum(nums=nums, target=13))

nums = [1,3,4,6,8,10,13]
target = 6
print(solution.twoSum(nums=nums, target=target))