from typing import List
class Solution:
    def maxSum(self, nums: List[int], k: int):
        max_sum = 0
        left = 0
        state =0
        for right in range(len(nums)):
            state += nums[right]
            if right - left + 1 == k:
                max_sum = max(max_sum, state)
                state -= nums[left]
                left+=1
        return max_sum
    
solution = Solution()
nums = [2, 1, 5, 1, 3, 2]
k = 3
result = solution.maxSum(nums, k)
print(result)