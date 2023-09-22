import sys
input = sys.stdin.readline
print = sys.stdout.write

def function():
    # write code down
    global res

    n, k = map(int, input().split())

    visited = [False]*100001
    dist = [0]*100001
    res = []

    bfs(n, k, visited, dist)

    return f"{len(res)-1}\n{' '.join(map(str, res[::-1]))}"

def bfs(n, k, visited, dist):
    global res

    from collections import deque

    q = deque()
    q.append(n)

    while q:
        x = q.popleft()
        if x == k:
            while n != x:
                res.append(x)
                x = dist[x]
            res.append(n)
            break
            
        for dx in (x-1, x+1, x*2):
            if 0 <= dx <= 100000 and not visited[dx]:
                visited[dx] = True
                q.append(dx)
                dist[dx] = x
    
if __name__ == '__main__':
    print(function())