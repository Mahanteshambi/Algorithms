def findRepeatedDnaSequences(s):
    
    # Replace this placeholder return statement with your code 
    seen, res = set(), set()
    for l in range(len(s) - 9):
        cur = s[l:l+10]
        if cur in seen:
            res.add(cur)
        seen.add(cur)
    return list(res)

def main():
    test_cases = [
        "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
        "AAAAAAAAAAAAA",
        "ACGTACGTACGTACGTACGTACGTACGTACGT",
        "GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG",
        "GTACGTACGTACGCCCCCCCCGGGGG",
    ]
    
    for i, s in enumerate(test_cases):
        print(f'{i+1}.\tInput: "{s}"')
        print(f"\n\tOutput: {findRepeatedDnaSequences(s)}")
        print("-" * 100)

if __name__ == "__main__":
    main()