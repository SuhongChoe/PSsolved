import sys
input = sys.stdin.readline
# print = sys.stdout.write

def function():
    # write code down
    # 연속된 수들의 부분함 중에 그 합이 S이상 되는것 중 가장 짧은 것의 길이 return

    # input
    # 1. n, s : 길이, 기준이 되는 합 (10 <= n < 100000, 0 < s <= 100000000)
    # 2. arr :  수열 (1 <= arr[i] <= 10000)

    # output
    # 1. 구하고자 하는 최소의 길이 출력 (단, 불가능하다면 0 출력)

    n, s = map(int, input().split())
    arr = list(map(int, input().split()))

    start, sub_s = 0, 0

    res = 1e8+1

    for i in range(n):
        sub_s += arr[i]
        while start <= i and s <= sub_s:
            res = min(res, i-start+1)
            sub_s -= arr[start]
            start += 1

    if res==1e8+1:
        res=0

    return str(res)

if __name__=='__main__':
    print(function())