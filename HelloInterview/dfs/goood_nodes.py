class TreeNode:
    def __init__(self, val: int, left: 'TreeNode' = None, right: 'TreeNode' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def __init__(self):
        self.nodes = []
        
    def dfs(self, root, max_):
        if not root:
            return 0
        count = 0
        if root.val >= max_:
            max_ = root.val
            count+=1
        left = self.dfs(root.left, max_)
        right = self.dfs(root.right, max_)
        return count + left + right
    
    def good_nodes(self, root, max_):
        if not root:
            return
        if root.val >= max_:
            max_ = root.val
            self.nodes.append(root)
        
        self.good_nodes(root.left, max_)
        self.good_nodes(root.right, max_)
        
    def good_nodes1(self, root, max_, nodes):
        if not root:
            return nodes
        if root.val >= max_:
            max_ = root.val
            nodes.append(root.val)
        left = self.good_nodes1(root.left, max_, nodes)
        right = self.good_nodes1(root.right, max_, left)
        return right
        
        
    
solution = Solution()
root = TreeNode(4, TreeNode(2, TreeNode(1), TreeNode(3)), TreeNode(7, TreeNode(6), TreeNode(9)))
count = solution.dfs(root, -float('inf'))
print(count)
solution.good_nodes(root, -float('inf'))
print([node.val for node in solution.nodes])
result = solution.good_nodes1(root, -float('inf'), [])
print([val for val in result])