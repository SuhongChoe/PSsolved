def dfs(graph, visited, node):
    visited[node] = True
    for next_node in range(len(graph)):
        if graph[node][next_node] == 1 and not visited[next_node]:
            dfs(graph, visited, next_node)



def solution(n, computers):
    # 네트워크의 개수를 파악하는 문제임
    # n개의 visited를 만들어서 전부 True 될때까지 탐색 하면 될듯
    # i -> j 를 갈 수 있다면 computers[i][j] == 1 그렇지 않다면 반대
    
    res = 0
    
    visited = [False]*n
    
    for node in range(n):
        if not visited[node]:
            dfs(computers, visited, node)
            res += 1

    return res
