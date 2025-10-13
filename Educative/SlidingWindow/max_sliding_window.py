import collections

def find_max_sliding_window(nums, w):
    output = []
    l, r = 0, 0
    q = collections.deque()
    while r < len(nums):
        while q and nums[q[-1]] < nums[r]:
            q.pop()
        q.append(r)
        if l > q[0]:
            q.popleft()
        if r+1 >= w:
            output.append(nums[q[0]])
            l+=1
        r+=1
    return output

# driver code
def main():
    window_sizes = [3, 3, 3, 3, 2, 4, 3, 2, 3, 6]
    nums_list = [
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        [10, 9, 8, 7, 6, 5, 4, 3, 2, 1],
        [10, 10, 10, 10, 10, 10, 10, 10, 10, 10],
        [1, 5, 8, 10, 10, 10, 12, 14, 15, 19, 19, 19, 17, 14, 13, 12, 12, 12, 14, 18, 22, 26, 26, 26, 28, 29, 30],
        [10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67],
        [4, 5, 6, 1, 2, 3],
        [9, 5, 3, 1, 6, 3],
        [2, 4, 6, 8, 10, 12, 14, 16],
        [-1, -1, -2, -4, -6, -7],
        [4, 4, 4, 4, 4, 4]
    ]

    for i in range(len(nums_list)):
        print(f"{i + 1}.\tInput list:\t{nums_list[i]}")
        print(f"\tWindow size:\t{window_sizes[i]}")
        output = find_max_sliding_window(nums_list[i], window_sizes[i])
        print(f"\n\tMaximum in each sliding window:\t{output}")
        print("-"*100)

if __name__ == '__main__':
    main()