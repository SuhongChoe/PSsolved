import sys
input = sys.stdin.readline
print = sys.stdout.write

def function():
    # write code down
    # 1. 화면 -> 클립보드
    # 2. 클립보드 -> 화면
    # 3. 화면에 있는 이모티콘 하나 삭제
    # 위의 모든 연산은 1초가 걸림
    # 기존 클립보드처럼 내용이 복사한다면 덮어쓰기가 됨
    # 클립보드에 있는 이모티콘 일부만 삭제 불가
    from collections import deque
    
    n = int(input())

    q = deque()
    q.append((1, 0))
    dist = [[sys.maxsize]*(n+1) for _ in range(n+1)]
    dist[1][0] = 0
    
    while q:
        s, c = q.popleft()

        if dist[s][s] > dist[s][c] + 1:
            dist[s][s] = dist[s][c] + 1
            q.append((s, s))
        if s+c <= n and dist[s+c][c] > dist[s][c] + 1:
            dist[s+c][c] = dist[s][c] + 1
            q.append((s+c, c))
        if s-1 >= 0 and dist[s-1][c] > dist[s][c] + 1:
            dist[s-1][c] = dist[s][c] + 1
            q.append((s-1, c))
    
    res = min(dist[n])
    
    return str(res)

if __name__ == '__main__':
    print(function())