import sys
input = sys.stdin.readline
print = sys.stdout.write

def function():
    # write code down

    # input
    # 1. m, n, k : 세로, 가로, 음식물 쓰레기 개수 (1 <= n,m <= 100, 1 <= k <= n*m)
    # 2~. y, x : 좌표

    # output
    # 영역이 가장 큰 음식물을 출력
    global visited, res, dx, dy, n, m

    m, n, k = map(int, input().split())
    graph = [[0]*n for _ in range(m)]
    for _ in range(k):
        y, x = map(int, input().split())
        graph[y-1][x-1] = 1
    visited = [[False]*n for _ in range(m)]

    res = 0

    dx = [0,0,1,-1]
    dy = [1,-1,0,0]

    for i in range(m):
        for j in range(n):
            if graph[i][j]==1 and not visited[i][j]:
                visited[i][j] = True
                bfs(graph, (j, i))
    
    
    return str(res)

def bfs(graph, start):
    global visited, res, dx, dy, n, m
    
    from collections import deque

    q = deque()
    q.append(start)
    cnt = 0

    while q:
        x, y = q.popleft()
        cnt += 1

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and graph[ny][nx]==1 and not visited[ny][nx]:
                q.append((nx, ny))
                visited[ny][nx] = True

    res = max(res, cnt)

if __name__ == '__main__':
    print(function())