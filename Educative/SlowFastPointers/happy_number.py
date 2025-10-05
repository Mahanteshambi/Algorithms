def is_happy_number(n):

    # Replace this placeholder return statement with your code
    slow = n
    def squared_no(n):
        total_sum = 0
        while n >0:
            n, digit = divmod(n, 10)
            total_sum+= digit**2
        return total_sum
    fast = squared_no(n)
    
    while fast !=1 and slow != fast:
        slow = squared_no(slow)
        fast = squared_no(squared_no(fast))
    if fast == 1:
        return True
    return False

def main():
    inputs = [1, 5, 19, 25, 7]
    for i in range(len(inputs)):
        print(i+1, ".\tInput Number: ", inputs[i], sep="")
        print("\n\tIs it a happy number? ", is_happy_number(inputs[i]))
        print("-" * 100)


if __name__ == '__main__':
    main()