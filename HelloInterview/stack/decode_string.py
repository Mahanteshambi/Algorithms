class Solution:
    def decodeString(self, s: str):
        stack = []
        for c in s:
            if c != ']':
                stack.append(c)
            else:
                char = ''
                while stack[-1] != '[':
                    char = stack.pop() + char
                stack.pop()
                k = ''
                while stack and stack[-1].isdigit():
                    k = stack.pop() + k
                stack.append(int(k) * char)
            
                
        return "".join(stack)

solution = Solution()
s = "3[a2[c]]"
result = solution.decodeString(s)
assert(result == "accaccacc")