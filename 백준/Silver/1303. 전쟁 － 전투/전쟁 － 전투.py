import sys
input = sys.stdin.readline
print = sys.stdout.write

def function():
    # write code down
    # 우리팀은 흰색
    # 적팀은 파란색
    # 같은팀의 병사들이 n명만큼 뭉쳐있을 때 n**2의 위력을 냄(단, 대각선의 경우는 생각하지 않음)

    # input
    # 1. n, m : 가로, 세로 크기 (1 <= n,m <= 100)
    # 2~m+1. graph : 병사들의 위치정보 + 옷 색 정보 (b: 파란색, w : 흰색) (무조건 한명이상씩 존재함)

    # output
    # 1. 우리팀 위력 합, 적팀 위력 합

    global n, m, dx, dy

    n, m = map(int, input().split())
    graph = [list(input().strip()) for _ in range(m)]

    visited = [[False]*n for _ in range(m)]

    res = {'W':0,
           'B':0} # W은 우리팀, B은 적팀

    dx = [0,0,1,-1]
    dy = [1,-1,0,0]

    for i in range(m):
        for j in range(n):
            if not visited[i][j]:
                visited[i][j] = True
                bfs(graph, visited, res, (i, j), graph[i][j])
    
    return f"{res['W']} {res['B']}"

def bfs(graph, visited, res, start, color):
    global n, m, dx, dy

    from collections import deque

    q = deque()
    q.append(start)
    cnt = 0

    while q:
        y, x = q.popleft()
        cnt += 1

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and graph[ny][nx]==color and not visited[ny][nx]:
                visited[ny][nx] = True
                q.append((ny, nx))

    res[color] += cnt**2

if __name__ == '__main__':
    print(function())