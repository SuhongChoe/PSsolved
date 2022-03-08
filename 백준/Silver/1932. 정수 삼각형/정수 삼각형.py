import sys

def solution():
    input = sys.stdin.readline

    n = int(input())

    Map = [list(map(int, input().split())) for _ in range(n)]
    dp = [[0]*(i+1) for i in range(n)]

    dp[0][0] = Map[0][0]

    for i in range(1,n):
        dp[i][0] = dp[i-1][0] + Map[i][0]
        dp[i][i] = dp[i-1][i-1] + Map[i][i]

    for i in range(1,n):
        for j in range(1,i):
            dp[i][j] = max(dp[i-1][j-1],dp[i-1][j]) + Map[i][j]

    print(max(dp[-1]))

solution()
