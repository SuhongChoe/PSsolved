import sys
def solution():
    input = sys.stdin.readline

    n, k = map(int, input().split())

    dp = [float('inf')]*100001
    for i in range(n+1): dp[n-i]=i

    for i in range(1,100001):
        a = dp[i//2]+1 if i%2==0 else float('inf')
        d = dp[(i+1)//2]+2 if i%2==1 else float('inf')
        b = dp[i-1]+1 if i-1>=0 else float('inf')
        c = dp[i+1]+1 if i+1<=100000 else float('inf')
        dp[i]= min(a,b,c,d,dp[i])
    print(dp[k])
solution()
