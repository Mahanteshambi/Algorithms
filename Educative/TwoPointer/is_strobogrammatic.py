def is_strobogrammatic(num):
  
    # Replace this placeholder return statement with your code
    strobo_dict = {'6':'9', '9':'6', '8':'8', '0':'0', '1':'1'}
    left, right = 0, len(num) -1
    while left<= right:
        if num[right] not in strobo_dict or num[left] != strobo_dict[num[right]]:
            return False
        left+=1
        right-=1
    return True

# Driver code
def main():
    nums = [
        "609",   
        "88",   
        "962",  
        "101",  
        "123"   
    ]

    i = 0
    for num in nums:
        print(i + 1, ".\tnum: ", num, sep="")
        print("\n\tIs strobogrammatic: ", is_strobogrammatic(num), sep="")
        print("-" * 100)
        i += 1

if __name__ == "__main__":
    main()