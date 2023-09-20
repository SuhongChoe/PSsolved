import sys
input = sys.stdin.readline
print = sys.stdout.write

def function():
    # write code down

    n = int(input())
    graph = [list(map(int, input().split())) for _ in range(n)]

    # 0 -> 가로 
    # 1 -> 대각선
    # 2 -> 세로
    dp = [[[0]*n for _ in range(n)] for _ in range(3)]
    for i in range(1, n):
        if graph[0][i] == 1:
            break
        dp[0][0][i] = 1

    for i in range(1, n):
        for j in range(1, n):
            # 가로
            if graph[i][j] == 0:
                # 가로
                dp[0][i][j] = dp[0][i][j-1] + dp[1][i][j-1]
                
                # 세로
                dp[2][i][j] = dp[2][i-1][j] + dp[1][i-1][j]

                # 대각선
                if (graph[i][j-1] | graph[i-1][j]) == 0:
                    dp[1][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1]

    res = sum(dp[i][-1][-1] for i in range(3))

    return str(res)

if __name__ == '__main__':
    print(function())