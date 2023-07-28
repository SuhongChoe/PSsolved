from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # n, k : 동전 종류, 가치의 합
    n, k = map(int, input().split())

    coins = [int(input()) for _ in range(n)]
    coins = [coin for coin in coins if coin <= k]
    coins.reverse()

    res = 0

    for coin in coins:
        res += k//coin
        k %= coin

    return str(res)
    
if __name__ == "__main__":
    print(function())