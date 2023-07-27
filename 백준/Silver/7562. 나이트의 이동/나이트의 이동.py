from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 첫재쭐 테스트케이스 개수
    # 첫쨰 채스판 한 변의 길이 i
    # 둘쨰 나이트가 현재 있는칸
    # 셋쨰 목적지

    res = []

    for _ in range(int(input())):
        I = int(input())
        cur_x, cur_y = map(int, input().split())
        arrive_x, arrive_y = map(int, input().split())
        visited = [[False]*I for _ in range(I)]

        t = bfs(visited, cur_x, cur_y, arrive_x, arrive_y)
        res.append(t)



    return '\n'.join(map(str, res))

def bfs(visited, start_x, start_y, arrive_x, arrive_y):
    from collections import deque

    q = deque([(start_x, start_y, 0)])
    I = len(visited)

    dx = [-2,-1,1,2,2,1,-1,-2]
    dy = [-1,-2,-2,-1,1,2,2,1]


    while q:
        x, y, cnt = q.popleft()
        if x==arrive_x and y==arrive_y:
            return cnt

        for i in range(8):
            nx, ny = x+dx[i], y+dy[i]
            if 0 <= nx < I and 0 <= ny < I and not visited[ny][nx]:
                visited[ny][nx] = True
                q.append((nx, ny, cnt+1))


if __name__ == "__main__":
    print(function())