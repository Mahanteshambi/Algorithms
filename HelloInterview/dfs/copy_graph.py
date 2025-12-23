class IntGraphNode:
    def __init__(self, value = 0, neighbors = None):
        self.value = value
        self.neighbors = neighbors if neighbors is not None else []
        
class Solution:
    def copy_graph(self, node):
        adj_list = {}
        def dfs(node):
            if node.value in adj_list:
                return
        
            adj_list[node.value] = [n.value for n in node.neighbors]
            for neighbor in node.neighbors:
                dfs(neighbor)
        if node:
            dfs(node)
        return adj_list
    
n1 = IntGraphNode(1)
n2 = IntGraphNode(2)
n3 = IntGraphNode(3)
n4 = IntGraphNode(4)

n1.neighbors = [n2, n4]
n2.neighbors = [n1, n3]
n3.neighbors = [n2, n4]
n4.neighbors = [n1, n3]
solution = Solution()
graph_dict = solution.copy_graph(n1)
print(graph_dict)
