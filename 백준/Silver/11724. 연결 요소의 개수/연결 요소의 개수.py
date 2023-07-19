from sys import stdin, stdout
input = stdin.readline
print = stdout.write


def function():
    # write down code
    # 그래프가 주어졌을 때 이어지는 그래프 개수를 구하셈
    from collections import defaultdict
    import sys
    sys.setrecursionlimit(5000)

    n, m = map(int, input().split())
    graph = defaultdict(list)
    visited = [False] * (n + 1)
    for _ in range(m):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)

    res = 0

    for node in range(1, n+1):
        if not visited[node]:
            visited[node] = True
            dfs(graph, visited, node)
            res += 1

    return str(res)


def dfs(graph, visited, node):
    visited[node] = True
    for next_node in graph[node]:
        if not visited[next_node]:
            dfs(graph, visited, next_node)


if __name__ == "__main__":
    print(function())