class TreeNode:
    def __init__(self, val: int, left: 'TreeNode' = None, right: 'TreeNode' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def calculateTilt(self, root: TreeNode):
        tilt = 0
        def dfs(root):
            nonlocal tilt
            if not root:
                return 0
            left = dfs(root.left)
            right = dfs(root.right)
            tilt += abs(left - right)
            return  root.val + left + right
        dfs(root)
        return tilt
    
solution = Solution()
root = TreeNode(4, TreeNode(2, TreeNode(1), TreeNode(3)), TreeNode(7, TreeNode(6), TreeNode(9)))
assert(solution.calculateTilt(root) == 21)