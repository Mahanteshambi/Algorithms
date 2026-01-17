from collections import deque
class TreeNode:
    def __init__(self, val: int, left: 'TreeNode' = None, right: 'TreeNode' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def maxWidth(self, root: TreeNode):
        if not root:
            return 0 
        queue = deque()
        queue.append([root, 0])
        max_width = 0
        while queue:
            _, left_pos = queue[0]
            level_size = len(queue)
            right_pos = -1
            for i in range(level_size):
                node, pos = queue.popleft()
                if i == level_size - 1:
                    right_pos = pos
                if node.left:
                    queue.append([node.left, pos * 2])
                if node.right:
                    queue.append([node.right, (pos * 2) + 1])
            max_width = max(max_width, right_pos - left_pos + 1)
        return max_width
                            
    
solution = Solution()
root_node = TreeNode(4, TreeNode(2, TreeNode(1)), TreeNode(7, None, TreeNode(9)))
assert(solution.maxWidth(root=root_node) == 4)