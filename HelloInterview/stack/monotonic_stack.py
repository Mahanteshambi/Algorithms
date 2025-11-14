class Solution:
    def nex_greater_element(self, input):
        result = [-1] * len(input)
        stack = []
        for i, c in enumerate(input):
            while stack and input[i] > input[stack[-1]]:
                index = stack.pop()
                result[index] = input[i]
            stack.append(i)
        return result
    
input = [2, 1, 3, 2, 4, 3]
solution = Solution()
result = solution.nex_greater_element(input)
output = [3, 3, 4, 4, -1, -1]
assert(result == output)