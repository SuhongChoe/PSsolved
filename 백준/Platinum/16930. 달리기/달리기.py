import sys
input = sys.stdin.readline
print = sys.stdout.write

def function():
    # write code down
    # 체육관 크기 n*m
    # 칸은 빈칸 또는 벽
    # 행, 열 로 표현함
    # 방향을 하나 고르고 1~k칸을 이동함
    

    # input
    # 1. m, n, k : 세로, 가로, 1초에 이동할 수 있는 거리 (2 <= n, m <= 1000, 1 <= k <= 1000)
    # 2~m+1. graph : 빈 칸 - '.', 벽 - '#'
    # m+2. x1, y1, x2, y2 : 도착점과 시작점 (서로다르고 항상 빈칸임)

    # output
    # 1. (x1, y1) 에서 (x2, y2)로 이동하는 최소 시간 (단, 이동할 수 없을 땐 -1)
    

    from collections import deque

    m, n, k = map(int, input().split())
    graph = [list(input().strip()) for _ in range(m)]
    y1, x1, y2, x2 = map(int, input().split())
   
    dx = [0,0,-1,1]
    dy = [1,-1,0,0]
    
    dist = [[1e6+1]*n for _ in range(m)]

    q = deque()
    q.append((y1-1, x1-1))
    dist[y1-1][x1-1] = 0
    
    while q:
        y, x = q.popleft()
        
        for i in range(4):
            nx, ny = dx[i]+x, dy[i]+y
            j = 1
            while j <= k and 0 <= nx < n and 0 <= ny < m and graph[ny][nx]=='.' and dist[ny][nx] > dist[y][x]:
                if dist[ny][nx] == 1e6+1:
                    q.append((ny, nx))
                    dist[ny][nx] = dist[y][x] + 1
                nx += dx[i]
                ny += dy[i]
                j += 1

    res = dist[y2-1][x2-1]
    if res == 1e6+1:
        res = -1
    
    return str(res)

if __name__ == '__main__':
    print(function())
