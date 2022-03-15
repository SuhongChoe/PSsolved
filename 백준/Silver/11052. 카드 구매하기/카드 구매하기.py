import sys

def solution():
    input = sys.stdin.readline

    n = int(input())
    cards = [0]+list(map(int,input().split()))

    dp = [0]*len(cards)

    for i in range(n+1):
        temp = [dp[i - j] + cards[j] for j in range(1, len(cards)) if i >= j]
        if temp:
            dp[i] = max(temp)

    print(dp[-1])

solution()