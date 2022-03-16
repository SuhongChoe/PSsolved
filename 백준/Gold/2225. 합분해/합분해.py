import sys

def solution():
    input = sys.stdin.readline

    n, k = map(int, input().split())

    dp = [[0]*201] + [[1]+[1]*201 for i in range(200)]

    for i in range(1,201):
        for j in range(1,201):
            dp[i][j] = (dp[i-1][j]+dp[i][j-1])%1000000000

    print(dp[k][n])

solution()