from typing import List

class Solution:
    def flood_fill(self, image: List[List[int]], sr: int, sc: int, color: int):
        rows, cols = len(image), len(image[0])
        org_color = image[sr][sc]
        
        if image[sr][sc] == color:
            return image
        
        def flood_fill_util(r, c):
            if image[r][c] == org_color:
                image[r][c] = color
                if r>=1: flood_fill_util(r-1, c)
                if r<rows-1: flood_fill_util(r+1, c)
                if c>=1: flood_fill_util(r, c-1)
                if c < cols-1: flood_fill_util(r, c+1)
                    
        flood_fill_util(sr, sc)
        return image
    
solution = Solution()
# image = [[1,0,1],[1,0,0],[0,0,1]]
# sr = 1
# sc = 1
# color = 2
# assert(solution.flood_fill(image, sr, sc, color) == [[1,2,1],[1,2,2],[2,2,1]])

image= [[0,0,0],[0,1,1]]
sr = 1
sc = 1
color = 1
assert(solution.flood_fill(image, sr, sc, color) == [[0,0,0],[0,1,1]])
