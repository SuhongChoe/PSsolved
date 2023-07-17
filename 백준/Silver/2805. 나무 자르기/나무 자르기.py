from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 자른부분의 윗부분을 가져감
    # 윗부분의 총합이 M 최소로하는 H의 최대값을 찾으셈
    # n 나무 개수, m 총합 길이
    # arr 나무들의 길이

    n, m = map(int, input().split())
    arr = list(map(int, input().split()))

    res = 0

    l, r = 1, max(arr)
    while l <= r:
        mid = (l+r)//2

        total_m = 0
        for i in arr:
            if i > mid:
                total_m += i - mid

        if total_m >= m: # 높이를 올려야함
            res = mid
            l = mid + 1
        else: # 높이를 내려야함
            r = mid - 1

    return str(res)
    
if __name__ == "__main__":
    print(function())