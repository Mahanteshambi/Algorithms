class TreeNode:
    def __init__(self, val: int, left: 'TreeNode' = None, right: 'TreeNode' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def pathSum(self, root: TreeNode, target: int):
        if not root:
            return False
        if not root.left and not root.right:
            return target == root.val
        
        left = self.pathSum(root.left, target - root.val)
        right = self.pathSum(root.right, target - root.val)
        return left or right
        
    
    def in_order(self, root):
        if not root:
            return 
        self.in_order(root.left)
        print(root.val)
        self.in_order(root.right)
    

root = TreeNode(4, TreeNode(2, TreeNode(1), TreeNode(3)), TreeNode(7, TreeNode(6), TreeNode(9)))
solution = Solution()
solution.in_order(root)
target = 13
# assert(solution.pathSum(root, target) == False)
assert(solution.pathSum(root, 17) == True)