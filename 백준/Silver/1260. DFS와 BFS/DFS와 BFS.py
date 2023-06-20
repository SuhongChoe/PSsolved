import sys
input=sys.stdin.readline

def function():
    # write down code
    # 방문할 수 있는 정점이 여러 개인 경우 정점 번호가 작은 것 먼저 방문
    # 간선은 양방향
    # n 정점의 개수
    # m 간선 개수
    # v 시작 번호
    from collections import defaultdict

    graph = defaultdict(list)

    n, m, v = map(int, input().split())

    # 양방향 그래프 그리기
    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    for i in range(n):
        graph[i+1].sort()

    res1 = dfs(graph, [False]*(n+1), v, [])
    res2 = bfs(graph, [False]*(n+1), v, [])

    return ' '.join(res1) + '\n' + ' '.join(res2)

def dfs(graph, visited, n, ans):
    ans.append(str(n)) # 해당 노드 번호 출력
    visited[n] = True # 1. 노드 방문 처리
    for i in graph[n]: # 2. 조건하에 인접한 노드 탐색
        if not visited[i]: # 3. 방문하지 않은 노드 탐색 실행
            dfs(graph, visited, i, ans)

    return ans

def bfs(graph, visited, n, ans):
    from collections import deque
    visited[n] = True
    q = deque([n])

    while q:
        n = q.popleft()
        ans.append(str(n)) # 해당 노드 번호 출력
        for i in graph[n]:
            if not visited[i]:
                q.append(i)
                visited[i] = True

    return ans

if __name__ == "__main__":
    print(function())