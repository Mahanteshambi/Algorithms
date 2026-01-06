from collections import deque
class TreeNode:
    def __init__(self, val: int, left: 'TreeNode' = None, right: 'TreeNode' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def level_order_sum(self, root: TreeNode):
        if not root:
            return []
        queue = deque()
        queue.append(root)
        result = []
        while queue:
            level_sum = 0
            for i in range(len(queue)):
                node = queue.popleft()
                level_sum+=node.val
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            result.append(level_sum)
        return result
            
    
solution = Solution()
intput = [1, 3, 4, None, 2, 7, None, 8]
tree_node = TreeNode(1, TreeNode(3, None, TreeNode(2, TreeNode(8))), TreeNode(4, TreeNode(7)))
assert(solution.level_order_sum(tree_node) == [1, 7, 9, 8])

