from sys import stdin, stdout
input=stdin.readline
print=stdout.write

# def function():
#     # write down code
#     # graph에서 1의 군집 개수를 구하는 문제
#     # graph 전체 그래프 탐색하면서 하면 최대 2500*2 5000임
#
#     res = []
#
#     for _ in range(int(input())):
#         # 가로, 세로, 배추 개수
#         n, m, k = map(int, input().split())
#         graph = [[0]*n for _ in range(m)]
#
#         cnt = 0
#
#         for _ in range(k):
#             x, y = map(int, input().split())
#             graph[y][x] = 1
#
#         for i in range(m):
#             for j in range(n):
#                 if graph[i][j]==1:
#                     cnt+=1
#                     bfs(graph, j, i)
#
#         res.append(cnt)
#
#     return '\n'.join(map(str, res))
#
# def bfs(graph, start_x, start_y):
#     from collections import deque
#     q = deque([(start_x, start_y)])
#     graph[start_y][start_x] = 0
#     n, m = len(graph[0]), len(graph)
#
#     dy = [1,-1,0,0]
#     dx = [0,0,-1,1]
#
#     while q:
#         x, y = q.popleft()
#
#         for i in range(4):
#             next_x, next_y = x+dx[i], y+dy[i]
#             if 0 <= next_x < n and 0 <= next_y < m and graph[next_y][next_x]==1:
#                 graph[next_y][next_x] = 0
#                 q.append((next_x, next_y))

def function():
    # write down code
    # 첫째줄 : t
    # 둘째줄 : 가로, 세로, 배추 개수
    from collections import defaultdict

    res = []

    for _ in range(int(input())):
        n, m, k = map(int, input().split())
        isthere = [[False]*n for _ in range(m)]

        cnt = 0

        for _ in range(k):
            x, y = map(int, input().split())
            isthere[y][x] = True

        for i in range(m):
            for j in range(n):
                if isthere[i][j]:
                    bfs(isthere, j, i)
                    cnt+=1

        res.append(cnt)

    return '\n'.join(map(str, res))

def bfs(isthere, start_x, start_y):
    from collections import deque

    dx = [1,0,-1,0]
    dy = [0,1,0,-1]
    n, m = len(isthere[0]), len(isthere)

    q = deque([(start_x,start_y)])
    isthere[start_y][start_x] = False

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0 <= nx < n and 0 <= ny < m and isthere[ny][nx]:
                isthere[ny][nx] = False
                q.append((nx, ny))

if __name__ == "__main__":
    print(function())