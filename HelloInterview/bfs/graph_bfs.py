from collections import deque

class GraphTraversal:
    
    def bfs_level(self, graph, start):
        queue = deque()
        queue.append(start)
        visited = set([start])
        result = []
        while queue:
            level = []
            for i in range(len(queue)):
                node = queue.popleft()
                level.append(node)
                for neighbour in graph[node]:
                    if neighbour not in visited:
                        visited.add(neighbour)
                        queue.append(neighbour)
            result.append(level)
        return result
    
solution = GraphTraversal()
adjList = {
    "1": ["2", "4"],
    "2": ["1", "3"],
    "3": ["2", "4"],
    "4": ["1", "3", "5"],
    "5": ["4"]
}
result = solution.bfs_level(adjList, "1")
print(result)