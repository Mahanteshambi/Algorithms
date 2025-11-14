class Solution:
    def longest_valid_parentheses(self, s: str):
        max_count = 0
        stack = [-1]
        for i, c in enumerate(s):
            if c == '(':
                stack.append(i)
            else:
                stack.pop()
                if not stack:
                    stack.append(i)
                else:
                    max_count = max(max_count, i - stack[-1])
        return max_count
    
solution = Solution()
s = "((()()"
assert(solution.longest_valid_parentheses(s) ==4)
s = "()(()"
assert(solution.longest_valid_parentheses(s) ==2)
s = "())))"
assert(solution.longest_valid_parentheses(s) == 2)
s = "((()()())"
assert(solution.longest_valid_parentheses(s) == 8)