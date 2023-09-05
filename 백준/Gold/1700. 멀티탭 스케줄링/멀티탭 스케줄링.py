from sys import stdin, stdout
input=stdin.readline
print=stdout.write

# def function():
#     # write code down
#     # input
#     # 1. n 멀티탭 구멍 개수 1 <= n <= 100
#     # 2. k 전기 용품 개수 1 <= k <= 100
#
#     # output
#     # 최소한의 플러그를 빼는 횟수
#
#     # solution
#     # 다음과 같은 3가지 경우가 발생
#     # 1. 콘센트에 빈자리가 있는 경우
#     # 2. 이미 꽂혀있는 경우
#     # 3. 새로운 전기용품을 꽂아야하는 경우
#
#     from collections import deque, defaultdict
#
#     n, k = map(int, input().split())
#     arr = list(map(int, input().split()))
#
#     dic = defaultdict(deque)
#     for i, v in enumerate(arr):
#         dic[v].append(i)
#
#     res = 0
#
#     plug = set([])
#
#     for elect in arr:
#         if len(plug) == n and elect not in plug:
#             last = 0
#             off = 0
#             for old_elect in plug:
#                 if not dic[old_elect]:
#                     off = old_elect
#                     break
#                 if last < dic[old_elect][0]:
#                     last = dic[old_elect][0]
#                     off = old_elect
#             plug.remove(off)
#             res += 1
#         plug.add(elect)
#         dic[elect].popleft()
#
#     return str(res)

# def function():
#     # write code down
#     # input
#     # 1. n, k : 멀티탭구멍, 용품 갯수 1 <= n <= 100 , 1 <= k <= 100
#     # 2. 멀티탭 정수 이름

#     # output
#     # 플러그를 뺴는 최소한의 횟수

#     # solution
#     # 세 가지 경우가 있다.
#     # 1. 구멍이 비어있는 경우
#     # 2. 이미 끼워져 있는 경우
#     # 3. 바꾸어야 할 경우

#     from collections import defaultdict, deque

#     n, k = map(int, input().split())
#     arr = list(map(int, input().split()))
#     dic = defaultdict(deque)
#     for id, el in enumerate(arr):
#         dic[el].append(id)
#     plug = set()

#     res = 0

#     for i in range(k):
#         elect = arr[i]
#         if len(plug) == n and elect not in plug:
#             latest, off_plug = 0, 0

#             for on_plug in plug:
#                 if not dic[on_plug]:
#                     off_plug = on_plug
#                     break
#                 if latest < dic[on_plug][0]: # 가장 마지막에 나타날 플러그를 뽑아야 함
#                     latest = dic[on_plug][0]
#                     off_plug = on_plug

#             plug.remove(off_plug)
#             res += 1

#         plug.add(elect)
#         dic[elect].popleft()

#     return str(res)

def function():
    # write code down
    # input
    # 1. n, k : 멀티탭 구멍 개수, 전기용품 개수 (1 <= n <= 100, 1 <= k <= 100)
    # 2. electric : 숫자이름으로 된 전기 용품 (1 <= elec[i] <= k)

    # output
    # 플러그를 최소한으로 뽑는 횟수

    # solution
    # 다음과 같은 세가지의 경우로 나뉜다.
    # 1. 멀티탭이 비어있는 구멍이 있을 경우
    # 2. 이미 꽂혀 있는 경우
    # 3. 멀티탭을 교체해야하는 경우

    n, k = map(int, input().split())
    elec = list(map(int, input().split()))

    res = 0

    using = set()

    for i, e in enumerate(elec):
        if len(using) == n and not e in using:
            lastest = 0
            for u_e in using:
                try:
                    if lastest < elec.index(u_e, i):
                        lastest = elec.index(u_e, i)
                        off_elec = u_e
                except:
                    off_elec = u_e
                    break
                    
            res += 1
            using.remove(off_elec)

        using.add(e)

    return str(res)
    

if __name__ == "__main__":
    print(function())