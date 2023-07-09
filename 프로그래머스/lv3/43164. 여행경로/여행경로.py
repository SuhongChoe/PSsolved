def dfs(graph, node, res):
    while graph[node]:
        next_node = graph[node].pop()
        dfs(graph, next_node, res)
    
    res.append(node)

def solution(tickets):
    # 모든 공항은 알파벳 대문자 3글자
    # 3 <= airport <= 10000
    # [a, b] == a -> b 가는 항공권이라는 거임
    # 주어진 항공권은 모두 사용하면서 경로가 여러개이면 사전이 빠른순으로 b를 정해서 가야함
    # 중복이 허용이 됨 -> visited 필요없음
    # 다만 돌아갈 길이 있는지는 확인해야할듯 -> 백트래킹 문제인듯????
    
    # solution 내가 문제 해석을 못함
    # 모든 도시를 방문할 수 있다했으니 어떻게든 한줄로 이어져 있으며 순환경로가 없다는 뜻임
    # 그냥 완전탐색 하면 되는 문제
    
    from collections import defaultdict
    
    graph = defaultdict(list)
    for a, b in tickets: 
        graph[a].append(b)
    
    for k, _ in graph.items(): 
        graph[k].sort(reverse=True)
    
    start = "ICN"
    
    res = []
    
    dfs(graph, start, res)
    
    return res[::-1]