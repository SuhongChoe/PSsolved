import sys

def solution():
    input = sys.stdin.readline

    temp = 1
    dp = [0]*100001
    dp[1] = 3

    for i in range(2, 100001):
        dp[i] = (dp[i-1]*3 - temp*2)%9901
        temp = (dp[i-1] - temp)%9901

    print(dp[int(input())]%9901)
solution()
