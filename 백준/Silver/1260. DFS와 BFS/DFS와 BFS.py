import sys
input=sys.stdin.readline

def function():
    # n 정점의 개수
    # m 간선의 개수
    # v 시작 정점 번호
    # 입력으로 주어지는 간선은 양방향
    # 정점 번호가 작은 것을 먼저 방문
    from collections import defaultdict
    n, m, v = map(int, input().split())

    graph = defaultdict(list)

    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    for i in range(n):
        graph[i+1].sort()

    res1 = dfs(graph, [False]*(n+1), v, [])
    res2 = bfs(graph, [False]*(n+1), v, [])

    return ' '.join(map(str, res1)) + '\n' + ' '.join(map(str, res2))


def bfs(graph, visited, n, result):
    from collections import deque
    q = deque([n])
    visited[n] = True

    while q:
        node = q.popleft()
        result.append(node)

        for next_node in graph[node]:
            if not visited[next_node]:
                visited[next_node] = True
                q.append(next_node)

    return result

def dfs(graph, visited, n, result):
    result.append(n)
    visited[n] = True
    for next_node in graph[n]:
        if not visited[next_node]:
            dfs(graph, visited, next_node, result)

    return result


if __name__ == "__main__":
    print(function())