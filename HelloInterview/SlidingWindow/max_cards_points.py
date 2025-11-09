from typing import List

class Solution:
    def maxScore(self, cards: List[int], k: int):
        left, right = 0, len(cards) - k
        total = sum(cards[right:])
        max_total = total
        while right < len(cards):
            total = total - cards[right] + cards[left]
            max_total = max(max_total, total)
            left+=1
            right+=1
        return max_total    

cards = [2,11,4,5,3,9,2]
k = 3
solution = Solution()
result = solution.maxScore(cards=cards, k=k)
print(result)