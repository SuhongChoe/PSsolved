import sys
input = sys.stdin.readline
print = sys.stdout.write

def function():
    # write code down

    # 수빈의 행동반경
    # 1. x-1
    # 2. x+1
    # 3. x*2

    # input
    # 1. n, k : 수빈이 위치, 동생 위치 (0 <= n, k <= 100000)

    # output
    # 1. 최단으로 찾는 시간
    # 2. 1에 해당하는 경우의 수
    global visited, k, res_time, res_cnt
    
    n, k = map(int, input().split())
    visited = [0]*100001

    res_time, res_cnt = sys.maxsize, 0

    bfs(n)

    return f"{res_time}\n{res_cnt}"

def bfs(n):
    global visited, k, res_time, res_cnt

    from collections import deque

    q = deque()
    q.append((n, 0))

    while q:
        x, t = q.popleft()

        if t > res_time:
            continue

        if x == k:
            if res_time == sys.maxsize:
                res_time = t
            if res_time == t:
                res_cnt += 1
        
        t += 1
        for dx in [x-1, x+1, 2*x]:
            if 0 <= dx <= 100000 and (visited[dx]==0 or visited[dx] == t):
                visited[dx] = t
                q.append((dx, t))

if __name__ == '__main__':
    print(function())