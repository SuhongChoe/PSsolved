import sys
input = sys.stdin.readline
print = sys.stdout.write

def function():
    # write code down

    # 가치의 합이 i원이 되도록 하는 동전의 최소 갯수

    global res

    n, k = map(int, input().split())
    arr = [int(input()) for _ in range(n)]
    arr = [i for i in arr if i <= k]
    dp = [1e4+1]*(k+1)
    dp[0] = 0

    for coin in arr:
        dp[coin] = 1

    for coin in arr:
        for i in range(coin, k+1):
            dp[i] = min(dp[i], dp[i-coin]+1)

    res = dp[-1]
    
    if res==1e4+1:
        res = -1
    
    return str(res)
    
if __name__ == '__main__':
    print(function())