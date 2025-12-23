from typing import List

class Solution:
    def graph_valid_tree(self, n: int, edges: List[List[int]]):
        adj_list = [[] for _ in range(n)]
        for u, v in edges:
            adj_list[u].append(v)
            adj_list[v].append(u)
        visited = [False] * n
        def has_cycle(node, visited, parent, adj_list):
            visited[node] = True
            for neighbor in adj_list[node]:
                if visited[neighbor] and parent != neighbor:
                    return True
                elif not visited[neighbor] and has_cycle(neighbor, visited, node, adj_list):
                    return True
            return False
        if has_cycle(0, visited, -1, adj_list):
            return False
        return all(visited)
        
    
solution = Solution()
n = 4 
edges = [[0, 1], [2, 3]]
assert(solution.graph_valid_tree(n, edges) == False)