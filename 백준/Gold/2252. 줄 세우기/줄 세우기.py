import sys
input = sys.stdin.readline
# print = sys.stdout.write

def function():
    # write code down
    # 일부 키를 비교한 결과로 줄을 세우는 프로그램?

    # input
    # 1. n, m : 학생 수(번호는 1~n), 키를 비교한 횟수 (1 <= n <= 32000, 1 <= m <= 100000)
    # 2~m+2. 학생 a,b (a<=b라는 의미)

    # output
    # 1. 오름차순으로 세운 결과를 출력

    n, m = map(int, input().split())
    graph = [[] for _ in range(n+1)]
    indegree = [0]*(n+1) # 진입차수
    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        indegree[b] += 1

    res = topology_sort(graph, indegree, n)

    return ' '.join(map(str, res))

def topology_sort(graph, indegree, n):
    from collections import deque

    res = []
    q = deque()

    for i in range(1, n+1):
        if indegree[i] == 0:
            q.append(i)

    while q:
        node = q.popleft()
        res.append(node)

        for next_node in graph[node]:
            indegree[next_node] -= 1
            if indegree[next_node] == 0:
                q.append(next_node)

    return res


if __name__ == '__main__':
    print(function())