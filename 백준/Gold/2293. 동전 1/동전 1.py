import sys
input = sys.stdin.readline
print = sys.stdout.write

def function():
    # write code down
    # 각각의 동전을 사용하여 가치가 k원이 되도록 한느 경우의 수
    # 각각의 동전은 몇개라도 사용 가능함

    # input
    # 1. n, k : 동전의 가치, 모두의 합의 기준이 되는 k (1 <= n <= 100, 1 <= k <= 10000)
    # 2~. arr : 쓸수있는 동전의 종류(개수는 상관없음) 1 <= arr[i] <= 100000

    # output
    # 동전을 모았을 때 만들 수 있는 경우의 수

    # solution
    # k 는 만이기 때문에 n번 만큼만 수행해야함
    # 가치의 합이 k원이 되도록 한다 -> 가치의 합이 1 <= i <= k 가 되도록 한다 -> 특정 동전을 썻을 때 i원이 되도록 한다. 이것이 dp
    # dp[0]은 하나의 동전만을 사용했을 때 점화식의 부족한 부분을 보완해 주기 위함

    n, k = map(int, input().split())
    arr = [int(input()) for _ in range(n)]
    dp = [0]*(k+1)
    dp[0] = 1

    for coin in arr:
        for i in range(coin, k+1):
            dp[i] += dp[i-coin]

    return str(dp[-1])

if __name__ == '__main__':
    print(function())