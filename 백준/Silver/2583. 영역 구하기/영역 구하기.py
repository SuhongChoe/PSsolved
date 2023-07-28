from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 첫째줄 : 세로, 가로, 영역 개수
    # 둘때줄 : 왼쪽아래 x,y 오른쪽 위 x,y
    # 0,0 부터 n,m 까지 있음

    m, n, k = map(int, input().split())
    iscolor = [[False] * n for _ in range(m)]
    cnt = 0
    res = []

    for _ in range(k):
        s_x, s_y, e_x, e_y = map(int, input().split())
        for y in range(s_y, e_y):
            for x in range(s_x, e_x):
                iscolor[y][x] = True

    for y in range(m):
        for x in range(n):
            if not iscolor[y][x]:
                iscolor[y][x] = True
                res.append(bfs(iscolor, x, y))
                cnt += 1

    res.sort()
    res = [str(cnt), ' '.join(map(str, res))]

    return '\n'.join(res)

def bfs(iscolor, start_x, start_y):
    from collections import deque

    res = 0
    dx = [1,-1,0,0]
    dy = [0,0,1,-1]
    n, m = len(iscolor[0]), len(iscolor)

    q = deque([(start_x, start_y)])

    while q:
        x, y = q.popleft()
        res += 1

        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0 <= nx < n and 0 <= ny < m and not iscolor[ny][nx]:
                iscolor[ny][nx] = True
                q.append((nx, ny))
    return res

if __name__ == "__main__":
    print(function())