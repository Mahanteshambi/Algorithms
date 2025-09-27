def is_palindrome(s):
    s1 = []
    for i in range(len(s)):
        if s[i].isalnum():
            s1.append(s[i].lower())
    left = 0
    right = len(s1) - 1
    while left < right:
        if s1[left] != s1[right]:
            return False
        left += 1
        right -= 1
    return True

def is_palindrome_2(s):
    left, right = 0, len(s) - 1
    while left < right:
        while left < right and not s[left].isalnum():
            left += 1
        while left < right and not s[right].isalnum():
            right -= 1
        if s[left].lower() != s[right].lower():
            return False
        left += 1
        right -= 1
    return True


print(is_palindrome("A man, a plan, a canal, Panama"))
print(is_palindrome("race a car"))
print(is_palindrome(" "))
print(is_palindrome("0P"))
print(is_palindrome(" "))

print(is_palindrome_2("A man, a plan, a canal, Panama"))
print(is_palindrome_2("race a car"))
print(is_palindrome_2(" "))
print(is_palindrome_2("0P"))
print(is_palindrome_2(" "))