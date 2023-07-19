from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 익은것 1, 익지 않은 것 0, 들어가 있지 않음 -1
    # return 도마도가 모두 익기까지 걸리는 시간
    # 1 -> 0 으로 퍼져 나가야함
    from collections import deque

    n, m = map(int, input().split())
    graph = [list(map(int, input().split())) for _ in range(m)]
    score = [[0]*n for _ in range(m)]

    q = deque([])

    for i in range(m):
        for j in range(n):
            if graph[i][j] == 1:
                q.append((j,i)) # x, y
                score[i][j] = 1

    bfs(graph, q, score)

    res = 0

    for i in range(m):
        for j in range(n):
            if graph[i][j] == 0 and score[i][j] == 0:
                return str(-1)
            if res < score[i][j]:
                res = score[i][j]

    return str(res - 1)


def bfs(graph, q, score):
    dx = [1,-1,0,0]
    dy = [0,0,-1,1]
    n, m = len(graph[0]), len(graph)

    while q:
        x, y = q.popleft()
        for i in range(4):
            next_x, next_y = x+dx[i], y+dy[i]
            if 0 <= next_x < n and 0 <= next_y < m and graph[next_y][next_x] == 0:
                graph[next_y][next_x] = 1
                score[next_y][next_x] = score[y][x] + 1
                q.append((next_x, next_y))


if __name__ == "__main__":
    print(function())