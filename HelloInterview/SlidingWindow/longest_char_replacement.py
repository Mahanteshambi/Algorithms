class Solution:
    def characterReplacement1(self, s: str, k: int):
        seen = {}
        left, res = 0, 0
        for right in range(len(s)):
            seen[s[right]] = seen.get(s[right], 0) + 1
            while ((right - left + 1) - max(seen.values())) > k:
                seen[s[left]]-=1
                left+=1
            res = max(res, (right - left + 1))
        return res
    
    def characterReplacement(self, s: str, k: int):
        seen = {}
        left, res = 0, 0
        max_freq = 0
        for right in range(len(s)):
            seen[s[right]] = seen.get(s[right], 0) + 1
            max_freq = max(max_freq, seen[s[right]])
            while ((right - left + 1) - max_freq) > k:
                seen[s[left]]-=1
                left+=1
            res = max(res, (right - left + 1))
        return res
solution = Solution()
s = "BBABCCDD"
k = 2
result = solution.characterReplacement(s, k)
print(result)