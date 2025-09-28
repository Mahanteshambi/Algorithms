def reverse_words(sentence):

    # Replace this placeholder return statement with your code
    sentence = sentence.strip().split()
    left = 0
    right = len(sentence) - 1
    while left < right:
        sentence[left], sentence[right] = sentence[right], sentence[left]
        left += 1
        right -= 1
    return " ".join(sentence)

print(reverse_words("  Hello   World  "))


