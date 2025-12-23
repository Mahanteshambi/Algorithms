class TreeNode:
    def __init__(self, val: int, left: 'TreeNode' = None, right: 'TreeNode' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def longestUnivaluePath(self, root: TreeNode):
        max_length = 0
        def dfs(root):
            nonlocal max_length
            if not root:
                return 0
            left_length = dfs(root.left)
            right_length = dfs(root.right)
            
            left_arrow = right_arrow = 0
            if root.left and root.left.val == root.val:
                left_arrow = left_length + 1
            if root.right and root.right.val == root.val:
                right_arrow = right_length + 1
            max_length = max(max_length, (left_arrow + right_arrow))
            return max(left_arrow, right_arrow)
        dfs(root)
        return max_length
    
solution = Solution()
root = TreeNode(1, TreeNode(4, TreeNode(4), TreeNode(4)), TreeNode(5, TreeNode(5)))
assert(solution.longestUnivaluePath(root) == 2)