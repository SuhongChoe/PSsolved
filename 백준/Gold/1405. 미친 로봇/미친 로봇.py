import sys
input = sys.stdin.readline
output = sys.stdout.write

dx = [1,-1,0,0]
dy = [0,0,1,-1]

def function():
    # write code down
    # n번 동서남북 방향으로 움직임
    # 들른 곳을 중복해서 방문하면 안됨

    # input
    # 1. n, e, w, s, n : 이동 횟수, ~확률 1 <= n <= 14

    # output
    # 단순할 확률

    # solution
    # dic을 통해서 단순한 것들을 모두 더함

    n, *per = map(int, input().split())
    per = list(map(lambda x: x/100, per))

    res = [0]
    dic = {i:0 for i in 'ewsn'}
    
    backtracking(res, per, 0, [(0, 0)], n, 1)

    return res[0]

def backtracking(res, per, cnt, visited, n, total):
    if cnt==n:
        res[0]+=total
        return
    x, y = visited[-1]
    for i in range(4):
        nx, ny = dx[i]+x, dy[i]+y
        if not (nx, ny) in visited:
            visited.append((nx, ny))
            backtracking(res, per, cnt+1, visited, n, total*per[i])
            visited.pop()

if __name__ == "__main__":
    print(function())