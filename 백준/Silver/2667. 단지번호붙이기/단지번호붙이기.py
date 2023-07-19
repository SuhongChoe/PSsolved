from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 1 집 0 빈집

    res = []

    n = int(input())
    graph = [list(input().strip()) for _ in range(n)]

    for i in range(n):
        for j in range(n):
            if graph[i][j] == '1':
                res.append(bfs(graph, j, i))

    res.sort()
    res = [len(res)] + res
    return '\n'.join(map(str, res))

def bfs(graph, start_x, start_y):
    from collections import deque

    dy = [1,-1,0,0]
    dx = [0,0,-1,1]
    n = len(graph)

    graph[start_y][start_x] = '0'
    q = deque([(start_x, start_y)])
    cnt = 1

    while q:
        x, y = q.popleft()

        for i in range(4):
            next_x, next_y = x+dx[i], y+dy[i]
            if 0 <= next_x < n and 0 <= next_y < n and graph[next_y][next_x] == '1':
                graph[next_y][next_x] = '0'
                q.append((next_x, next_y))
                cnt+=1

    return cnt

    
if __name__ == "__main__":
    print(function())