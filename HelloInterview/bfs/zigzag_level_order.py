from collections import deque
class TreeNode:
    def __init__(self, val: int, left: 'TreeNode' = None, right: 'TreeNode' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def bfs(self, root:TreeNode):
        if not root:
            return []
        queue = deque()
        queue.append(root)
        result = []
        while queue:
            node = queue.popleft()
            result.append(node.val)
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        return result
    
    def zig_zag(self, root: TreeNode):
        left_to_right = False
        queue = deque()
        queue.append(root)
        result = []
        while(queue):
            level = deque()
            for i in range(len(queue)):
                node = queue.popleft()
                if node.right: 
                    queue.append(node.right)
                if node.left:
                    queue.append(node.left)
                if left_to_right:
                    level.append(node.val)
                else:
                    level.appendleft(node.val)
                
            result.append(list(level))
            left_to_right = not left_to_right
        return result


input = [1, 3, 4, None, 2, 7, None, 8]
solution = Solution()
root_node = TreeNode(1, TreeNode(3, None, TreeNode(2, TreeNode(8))), TreeNode(4, TreeNode(7)))
assert(solution.zig_zag(root=root_node)==[[1], [4, 3], [2, 7], [8]])
# result = solution.bfs(root=root_node)
# print(result)