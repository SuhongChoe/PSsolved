import sys
input = sys.stdin.readline
print = sys.stdout.write

def function():
    # write code down
    # 한칸엔 무조건 한마리
    # 어떤칸의 안전거리 = 가장 가까운 상어와의 거리
    # 거리는 가로, 세로, 대각선

    # input
    # 1. m,n : 세로, 가로 (2 <= m,n <= 50)
    # 2~. graph : 상어 대한 정보 (0: 빈칸, 1: 상어)

    # output
    # 1. 안전 거리의 최댓값

    from collections import deque

    dx = [0,1,1,1,0,-1,-1,-1]
    dy = [1,1,0,-1,-1,-1,0,1]
    
    m, n = map(int, input().split())
    graph = [list(map(int, input().split())) for _ in range(m)]
    dist = [[0]*n for _ in range(m)]

    q = deque((i, j) for i in range(m) for j in range(n) if graph[i][j]==1)

    while q:
        y, x = q.popleft()

        for i in range(8):
            nx, ny = dx[i] + x, dy[i] + y
            if 0 <= nx < n and 0 <= ny < m and graph[ny][nx] == 0 and dist[ny][nx]==0:
                dist[ny][nx] = dist[y][x] + 1
                q.append((ny, nx))

    res = 0
    for i in range(m):
        for j in range(n):
            res = max(res, dist[i][j])
    
    return str(res)

if __name__ == '__main__':
    print(function())