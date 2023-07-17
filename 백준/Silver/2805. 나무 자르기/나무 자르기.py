from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 자른부분의 윗부분을 가져감
    # 윗부분의 총합이 M 최소로하는 H의 최대값을 찾으셈
    # n 나무 개수, m 총합 길이
    # arr 나무들의 길이

    # solution
    # 개쩌는거 찾음
    # 나무의 길이가 중복이 될 수 있기에 Counter로 이걸 더 빠르게 처리할 수 있음

    from collections import Counter

    n, m = map(int, input().split())
    tree = Counter(map(int, input().split()))

    res = 0

    l, r = 1, 2000000000
    while l <= r:
        mid = (l+r)//2

        total_m = 0
        for h, i in tree.items():
            if h > mid:
                total_m += (h - mid) * i

        if total_m >= m: # 높이를 올려야함
            res = mid
            l = mid + 1
        else: # 높이를 내려야함
            r = mid - 1

    return str(res)
    
if __name__ == "__main__":
    print(function())