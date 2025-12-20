class TreeNode:
    def __init__(self, val: int, left: 'TreeNode' = None, right: 'TreeNode' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def pathSum(self, root: TreeNode, target: int):
        result = []
        def dfs(root, target, path):
            nonlocal result
            if not root:
                return
            path.append(root.val)
            if not root.left and not root.right:
                if root.val == target:
                    result.append(path[:]) 
            
            dfs(root.left, target - root.val, path)
            dfs(root.right, target - root.val, path)
            path.pop()
        dfs(root, target, [])
        return result
    
solution = Solution()
root = TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(7)), TreeNode(4, TreeNode(5), TreeNode(1)))
assert(solution.pathSum(root, 10) == [[1,2,7],[1,4,5]] or solution.pathSum(root, 10) == [[1,4,5],[1,2,7]])