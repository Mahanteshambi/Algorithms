from typing import List

class Solution:
    def maxSum(self, nums: List[int], k: int):
        left=0
        seen= {}
        total, max_total = 0, 0
        for right in range(len(nums)):
            total += nums[right]
            seen[nums[right]] = seen.get(nums[right], 0) + 1
            if right - left + 1 == k:
                if not max(seen.values()) > 1:
                    max_total = max(max_total, total)
                total-=nums[left]
                seen[nums[left]] -= 1
                left += 1
        return max_total
                

nums = [3, 2, 2, 3, 4, 6, 7, 7, -1]
k = 4
solution = Solution()
result = solution.maxSum(nums, k)
print(result)