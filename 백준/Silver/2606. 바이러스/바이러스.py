import sys
input = sys.stdin.readline
print = sys.stdout.write

def function():
    # write code down

    # input
    # 1. n : 컴퓨터 수 (1 <= n <= 100) 각 컴퓨터의 번호는 1~n까지 붙혀져 있음
    # 2. k : 연결된 컴퓨터 쌍
    # 3~. graph : 컴퓨터 네트워크 정보

    # output
    # 1. 1번 컴퓨터가 바이러스에 걸렸을 때 감염되는 컴퓨터의 총 수 출력
    global res

    from collections import defaultdict
    
    n = int(input())
    k = int(input())
    graph = defaultdict(list)
    res = 0
    
    for _ in range(k):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    visited = [False]*(n+1)

    bfs(graph, visited)
    
    return str(res-1)

def bfs(graph, visited):
    global res
    
    from collections import deque

    q = deque()
    q.append(1)
    visited[1] = True

    while q:
        node = q.popleft()
        res += 1

        for next_node in graph[node]:
            if not visited[next_node]:
                q.append(next_node)
                visited[next_node] = True
    
    
if __name__ == '__main__':
    print(function())