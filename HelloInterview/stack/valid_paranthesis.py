class Solution:
    def isValid(self, s: str):
        mapping = {']':'[', '}': '{', ')':'('}
        stack = []
        for c in s:
            if c in mapping:
                if not stack or stack[-1] != mapping[c]:
                    return False
                stack.pop()
            else:
                stack.append(c)
        return len(stack) == 0

s = "()(())"
solution = Solution()
result = solution.isValid(s)
assert(result == True)

s = "(){({}})"
result = solution.isValid(s)
assert(result == False)