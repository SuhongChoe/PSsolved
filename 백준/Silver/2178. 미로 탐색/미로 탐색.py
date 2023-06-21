import sys
input=sys.stdin.readline

def function():
    # write down code
    # 1. n, m 행 열
    # 2. 1: 이동 가능, 0: 이동 불가능
    # 3. 1, 1 -> n,m으로 이동할떄 지나하야하는 최소 칸 수 return
    # 특이사항: 항상 도착위치로 이동 가능함
    # 최소 칸으로 이동해야 하기에 왔던 칸으로 돌아갈 이유 없음

    n, m = map(int, input().split())

    graph = [input().strip() for _ in range(n)]
    visitied = [[False]*m for _ in range(n)]

    return bfs(graph, visitied)

def bfs(graph, visited):
    from collections import deque
    # 상, 하, 좌, 우
    dy = [-1, 1, 0, 0]
    dx = [0, 0, 1, -1]

    n, m = len(graph), len(graph[0])

    q = deque([[0, 0, 1]])
    visited[0][0] = True

    while q:
        y, x, cnt = q.popleft()

        if y == n - 1 and x == m - 1:
            return cnt
        for i in range(4): # 1. 현재 노드에서 상, 하, 좌, 우 탐색
            ny, nx = y+dy[i], x+dx[i]
            if 0 <= ny < n and 0 <= nx < m and graph[ny][nx] == '1' and not visited[ny][nx]: # 범위를 벗어나지 않는지 and 방문 가능한지 판단
                q.append([ny, nx, cnt+1])
                visited[ny][nx] = True



if __name__ == "__main__":
    print(function())