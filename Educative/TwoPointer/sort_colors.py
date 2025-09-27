def sort_colors(colors):
    
    # Replace this placeholder return statement with your code
    l, r = 0, len(colors)- 1
    i =0
    while i <= r:
        if colors[i] == 0:
            colors[i], colors[l] = colors[l], colors[i]
            l+=1
        elif colors[i] == 2:
            colors[i], colors[r] = colors[r], colors[i]
            r-=1
            i-=1
        i+=1
    return colors

def main():
    inputs = [[0, 1, 0], [1, 1, 0, 2], [2, 1, 1, 0, 0], [2, 2, 2, 0, 1, 0], [2, 1, 1, 0, 1, 0, 2]]

    for i in range(len(inputs)):
        colors=inputs[i]
        print(i + 1, ".\tcolors:", colors)
        sort_colors(colors)
        print("\n\tThe sorted array is:", colors)
        print("-" * 100)

if __name__ == "__main__":
    main()