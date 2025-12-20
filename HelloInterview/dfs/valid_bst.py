class TreeNode:
    def __init__(self, val: int, left: 'TreeNode' = None, right: 'TreeNode' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def validateBST(self, root: TreeNode):
        def dfs(root, min_, max_):
            if not root:
                return True
            if root.val <= min_ or root.val >= max_:
                return False
            return dfs(root.left, min_, root.val) and dfs(root.right, root.val, max_)
        
        return dfs(root, float('-inf'), float('inf'))
    
solution = Solution()

root = TreeNode(1, None, TreeNode(1))
assert(solution.validateBST(root) == False)

root = TreeNode(4, TreeNode(1), TreeNode(5, TreeNode(3), TreeNode(6)))
assert(solution.validateBST(root) == False)

root = TreeNode(4, TreeNode(2, TreeNode(1), TreeNode(3)), TreeNode(7, TreeNode(6), TreeNode(9)))
assert(solution.validateBST(root) == True)