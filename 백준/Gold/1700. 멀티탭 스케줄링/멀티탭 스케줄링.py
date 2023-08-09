from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write code down
    # input
    # 1. n 멀티탭 구멍 개수 1 <= n <= 100
    # 2. k 전기 용품 개수 1 <= k <= 100

    # output
    # 최소한의 플러그를 빼는 횟수

    # solution
    # 다음과 같은 3가지 경우가 발생
    # 1. 콘센트에 빈자리가 있는 경우
    # 2. 이미 꽂혀있는 경우
    # 3. 새로운 전기용품을 꽂아야하는 경우

    from collections import deque, defaultdict

    n, k = map(int, input().split())
    arr = list(map(int, input().split()))

    dic = defaultdict(deque)
    for i, v in enumerate(arr):
        dic[v].append(i)

    res = 0

    plug = set([])

    for elect in arr:
        if len(plug) == n and elect not in plug:
            last = 0
            off = 0
            for old_elect in plug:
                if not dic[old_elect]:
                    off = old_elect
                    break
                if last < dic[old_elect][0]:
                    last = dic[old_elect][0]
                    off = old_elect
            plug.remove(off)
            res += 1
        plug.add(elect)
        dic[elect].popleft()

    return str(res)
    
if __name__ == "__main__":
    print(function())