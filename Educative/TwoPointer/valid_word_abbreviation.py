def valid_word_abbreviation(word, abbr):
    i, j = 0, 0
    while i < len(word) and j < len(abbr):
        if abbr[j].isdigit():
            if abbr[j] == '0':
                return False
            k = 0
            while j < len(abbr) and abbr[j].isdigit():
                k= k * 10 + int(abbr[j])
                j+=1
            i+=k
        else:
            if i >= len(word) or word[i] != abbr[j]:
                return False
            i+=1
            j+=1
    return i == len(word) and j == len(abbr)
def main():
    words = ["a", "a", "abcdefghijklmnopqrst", "abcdefghijklmnopqrst", "word", "internationalization", "localization"]
    abbreviations = ["a", "b", "a18t", "a19t", "w0rd", "i18n", "l12n"]

    for i in range(len(words)):
        print(i + 1, ".\t word: '", words[i], "'", sep="")
        print("\t abbr: ", abbreviations[i], "'", sep="")
        print(f"\n\t Is '{abbreviations[i]}' a valid abbreviation for the word '{words[i]}'? ", valid_word_abbreviation(words[i], abbreviations[i]), sep="")
        print("-" * 100)

if __name__ == '__main__':
    main()