def dfs(graph, node, res):
    while graph[node]:
        next_node = graph[node].pop()
        res.append(dfs(graph, next_node, res))
    
    return node
    

def solution(tickets):
    # 주어진 항공권을 모두 사용하여 경로를 탐색
    # 모든 도시를 방문할 수 없는 경우는 없음 -> 어떻게든 한줄로 이어진다는 뜻
    # graph를 형성하고 ICN부터 방문하여 dfs하면됨
    
    from collections import defaultdict
    
    graph = defaultdict(list)
    
    for a, b in tickets:
        graph[a].append(b)
    for k, _ in graph.items():
        graph[k].sort(reverse=True) # 알파벳 순으로 탐색하기 위함
    
    res = []

    dfs(graph, "ICN", res)
    
    return ["ICN"]+res[::-1]