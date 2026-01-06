from collections import deque
class TreeNode:
    def __init__(self, val: int, left: 'TreeNode' = None, right: 'TreeNode' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def rightmostNode(self, root: TreeNode):
        if not root:
            return []
        queue = deque()
        queue.append(root)
        result = []
        while queue:
            level_size = len(queue)
            for i in range(len(queue)):
                node = queue.popleft()
                if i == level_size - 1:
                    result.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                
        return result
    
solution = Solution()
input = [1, 3, 4, None, 2, 7, None, 8]
tree_node = TreeNode(1, TreeNode(3, None, TreeNode(2, TreeNode(8))), TreeNode(4, TreeNode(7)))
assert(solution.rightmostNode(tree_node) == [1, 4, 7, 8])