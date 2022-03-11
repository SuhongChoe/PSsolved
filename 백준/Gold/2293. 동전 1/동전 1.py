import sys

def solution():
    input = sys.stdin.readline

    n, k = map(int, input().split())
    coins = [int(input()) for _ in range(n)]

    dp = [0]*10001
    dp[0] = 1

    for coin in coins:
        for i in range(coin,10001):
            dp[i] += dp[i-coin]

    print(dp[k])
solution()
