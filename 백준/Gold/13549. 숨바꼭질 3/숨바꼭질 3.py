import sys
input = sys.stdin.readline
print = sys.stdout.write

def function():
    # write code down

    # 1초 후
    # 1. x-1
    # 2. x+1
    
    # 0초 후
    # 1. 2*x

    # input
    # 1. n, k : 수빈 위치, 동생 위치

    # output
    # 1. 동생을 찾는 가장 빠른 시간

    global res

    n, k = map(int, input().split())

    visited = [False]*100001

    res = 0

    bfs(n, k, visited)

    return str(res)

def jump(x, t, q, visited):
    while x <= 100000:
        if not visited[x]:
            q.append((x, t))
            visited[x] = True
        else:
            break
        x *= 2

def bfs(n, k, visited):
    global res

    from collections import deque

    q = deque()
    jump(n, 0, q, visited)

    while q:
        x, t = q.popleft()

        if x == k:
            res = t
            return

        t += 1
        for dx in [x-1, x+1]:
            if 0 <= dx <= 100000 and not visited[dx]:
                jump(dx, t, q, visited)
                
if __name__ == '__main__':
    print(function())