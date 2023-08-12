from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write code down
    # input
    # 1. n, k : 멀티탭구멍, 용품 갯수 1 <= n <= 100 , 1 <= k <= 100
    # 2. 멀티탭 정수 이름

    # output
    # 플러그를 뺴는 최소한의 횟수

    # solution
    # 세 가지 경우가 있다.
    # 1. 구멍이 비어있는 경우
    # 2. 이미 끼워져 있는 경우
    # 3. 바꾸어야 할 경우

    from collections import defaultdict, deque

    n, k = map(int, input().split())
    arr = list(map(int, input().split()))
    dic = defaultdict(deque)
    for id, el in enumerate(arr):
        dic[el].append(id)
    plug = set()

    res = 0

    for i in range(k):
        elect = arr[i]
        if len(plug) == n and elect not in plug:
            latest, off_plug = 0, 0

            for on_plug in plug:
                if not dic[on_plug]:
                    off_plug = on_plug
                    break
                if latest < dic[on_plug][0]: # 가장 마지막에 나타날 플러그를 뽑아야 함
                    latest = dic[on_plug][0]
                    off_plug = on_plug

            plug.remove(off_plug)
            res += 1

        plug.add(elect)
        dic[elect].popleft()

    return str(res)
    
if __name__ == "__main__":
    print(function())