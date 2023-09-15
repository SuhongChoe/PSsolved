import sys
input=sys.stdin.readline
print=sys.stdout.write

# def old_fun():
#     def function():
#         # write down code
#         # 방문할 수 있는 정점이 여러 개인 경우 정점 번호가 작은 것 먼저 방문
#         # 간선은 양방향
#         # n 정점의 개수
#         # m 간선 개수
#         # v 시작 번호
#         from collections import defaultdict

#         graph = defaultdict(list)

#         n, m, v = map(int, input().split())

#         # 양방향 그래프 그리기
#         for _ in range(m):
#             a, b = map(int, input().split())
#             graph[a].append(b)
#             graph[b].append(a)

#         for i in range(n):
#             graph[i+1].sort()

#         res_dfs = dfs(graph, [False]*(n+1), v, [])
#         res_bfs = bfs(graph, [False]*(n+1), v, [])

#         return ' '.join(res_dfs) + '\n' + ' '.join(res_bfs)

#     def dfs(graph, visited, n, ans):
#         # DFS
#         # 1. 노드 방문 처리
#         # 2. 해당 노드와 인접한 노드 탐색
#         # 3. 방문하지 않았다면 1로 돌아가기 위해 recursive 함수 실행

#         ans.append(str(n)) # 해당 노드 번호 출력
#         visited[n] = True # 1. 노드 방문 처리
#         for i in graph[n]: # 2. 인접한 노드 탐색
#             if not visited[i]:
#                 dfs(graph, visited, i, ans) # 3. 방문하지 않았다면 1로 돌아가기 위해 recursive 함수 실행

#         return ans

#     def bfs(graph, visited, n, ans):
#         # BFS
#         # 1. 첫번째 노드 방문 처리
#         # 2. queue에 노드 넣기
#         # 3. queue에서 먼저 넣은 노드 빼기
#         # 4. 해당 노드와 인접한 노드 탐색
#         # 5. 방문하지 않았다면 queue에 해당 노드를 넣고 방문 처리하기

#         from collections import deque
#         visited[n] = True # 1. 첫 번쨰 노드 방문 처리
#         q = deque([n]) # 2. queue에 노드 넣기

#         while q:
#             n = q.popleft() # 3. queue에서 먼저들어온 노드 빼기
#             ans.append(str(n)) # 해당 노드 번호 출력
#             for i in graph[n]: # 4. 인접한 노드 탐색
#                 if not visited[i]:
#                     q.append(i) # 5. 방문하지 않았다면 queue에 해당 노드를 넣고 방문 처리하기
#                     visited[i] = True

#         return ans

# def old2_function():
#     # n 정점의 개수
#     # m 간선의 개수
#     # v 시작 정점 번호
#     # 입력으로 주어지는 간선은 양방향
#     # 정점 번호가 작은 것을 먼저 방문
#     from collections import defaultdict
#     n, m, v = map(int, input().split())

#     graph = defaultdict(list)

#     for _ in range(m):
#         a, b = map(int, input().split())
#         graph[a].append(b)
#         graph[b].append(a)

#     for k in graph.keys():
#         graph[k].sort()

#     res_dfs = dfs(graph, [False]*(n+1), v, [])
#     res2 = bfs(graph, [False]*(n+1), v, [])

#     return ' '.join(map(str, res_dfs)) + '\n' + ' '.join(map(str, res2))

# def function():
#     # 그래프탐색방법으로 dfs bfs 구현
#     # 단, 우선순위는 번호가 적은것
#     # 1 <= v <= N
#     # 간선은 양방향
#     from collections import defaultdict

#     n, m, v = map(int, input().split())

#     graph = defaultdict(list)
#     for _ in range(m):
#         a, b = map(int, input().split())
#         graph[a].append(b)
#         graph[b].append(a)


#     res_dfs = [v]
#     res_bfs = [v]
#     dfs(graph, set([v]), v, res_dfs)
#     bfs(graph, set([v]), v, res_bfs)

#     res = ' '.join(map(str, res_dfs)) + '\n' + ' '.join(map(str, res_bfs))

#     return res

# def dfs(graph, visited, node, res):
#     graph[node].sort()
#     for next_node in graph[node]:
#         if not next_node in visited:
#             visited.add(next_node)
#             res.append(next_node)
#             dfs(graph, visited, next_node, res)

# def bfs(graph, visited, start, res):
#     from collections import deque

#     q = deque([start])

#     while q:
#         node = q.popleft()

#         for next_node in graph[node]:
#             if not next_node in visited:
#                 visited.add(next_node)
#                 res.append(next_node)
#                 q.append(next_node)




# # def bfs(graph, visited, n, result):
# #     from collections import deque
# #     q = deque([n])
# #     visited[n] = True
# #
# #     while q:
# #         node = q.popleft()
# #         result.append(node)
# #
# #         for next_node in graph[node]:
# #             if not visited[next_node]:
# #                 visited[next_node] = True
# #                 q.append(next_node)
# #
# #     return result
# #
# # def dfs(graph, visited, n, result):
# #     result.append(n)
# #     visited[n] = True
# #     for next_node in graph[n]:
# #         if not visited[next_node]:
# #             dfs(graph, visited, next_node, result)
# #
# #     return result

def function():
    # write code down

    # input
    # 1. n, m, v : 정점의 개수, 간선의 개수, 정점 번호 (1 <= n <= 1000, 1 <= m <= 10000, 1 <= v <= n)
    # 2~. a, b : 연결된 두 정점 정보 (양방향 간선)
    global n, m, v, graph

    from collections import defaultdict
    
    n, m, v = map(int, input().split())
    graph = defaultdict(list)
    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    for i in graph.keys():
        graph[i].sort()

    res_dfs = ' '.join(map(str, dfs(v, [False]*(n+1), [])))
    res_bfs = ' '.join(map(str, bfs(v, [False]*(n+1), [])))

    res = [res_dfs, res_bfs]
    
    return '\n'.join(res)

def bfs(start, visited, res):
    global n, m, v, graph
    
    from collections import deque

    q = deque()
    q.append(start)
    visited[start] = True

    while q:
        node = q.popleft()
        res.append(node)

        for next_node in graph[node]:
            if not visited[next_node]:
                visited[next_node] = True
                q.append(next_node)

    return res

def dfs(node, visited, res):
    visited[node] = True
    res.append(node)
    
    for next_node in graph[node]:
        if not visited[next_node]:
            dfs(next_node, visited, res)

    return res
    
if __name__ == "__main__":
    print(function())