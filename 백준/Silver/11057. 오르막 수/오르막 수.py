import sys

def solution():
    input = sys.stdin.readline

    dp = [1]*10

    n = int(input())

    for _ in range(n-1):
        new_dp = dp[:]
        for i in range(10):
            new_dp[i] = sum(dp[:i+1])
        dp = new_dp

    print(sum(dp)%10007)

solution()
