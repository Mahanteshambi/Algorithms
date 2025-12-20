class TreeNode:
    def __init__(self, val: int, left: 'TreeNode' = None, right: 'TreeNode' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def maxDiameter(self, root: TreeNode):
        max_dia = 0
        def dfs(root):
            nonlocal max_dia
            if not root:
                return 0
            left = dfs(root.left)
            right = dfs(root.right)
            if left + right > max_dia:
                max_dia = left + right
            return 1 + max(left, right)
        dfs(root)
        return max_dia
        
    
solution = Solution()
root = TreeNode(3, TreeNode(9, TreeNode(1, None, TreeNode(5)), TreeNode(4)), TreeNode(2))
assert(solution.maxDiameter(root) == 4)
