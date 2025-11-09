class Solution:
    def longestSubstringWithoutRepeat1(self, s: str):
        max_length = 0
        seen = {}
        start = 0
        for end in range(len(s)):
            seen[s[end]] = seen.get(s[end], 0) + 1
            while seen[s[end]] > 1:
                seen[s[start]]-=1
                start+=1
            max_length = max(max_length, end-start+1)
        return max_length
    
    def longestSubstringWithoutRepeat(self, s):
        state = {}
        start = 0
        max_length = 0

        for end in range(len(s)):
            if s[end] in state:
                start = max(start, state[s[end]] + 1)

            state[s[end]] = end
            max_length = max(max_length, end - start + 1)
        return max_length
            
    
solution = Solution()
s = "eghghhgg"
result = solution.longestSubstringWithoutRepeat(s)
print(result)