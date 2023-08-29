from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 1. 최소 한개 모음 aeiou + 최소 두개의 자음
    # 2. 정렬된 문자열이여야 함

    # input
    # 1. L, C : 구성되어야 하는 알파벳 개수, 총 문자 개수 (3 <= L <= C <= 15)
    # 2. C개의 문자 (주어진 문자는 소문자, 중복 x)

    # output
    # 가능한 문자들 전부 출력

    res = []

    l, c = map(int, input().split())
    arr = input().split()
    arr.sort() # 정렬시키기 위함

    backtracking(arr, 0, 0, '', res, l, c)

    return '\n'.join(res)

def backtracking(arr, i, cnt, key, res, l, c):
    if cnt == l and check(key):
        res.append(key)

    for j in range(i, c):
        key += arr[j]
        backtracking(arr, j+1, cnt+1, key, res, l, c)
        key = key[:-1]


def check(key):
    from collections import Counter

    mo, ja = 0, 0
    for k, v in Counter(key).items():
        if k in 'aeiou':
            mo += v
        else:
            ja += v

    return mo >= 1 and ja >= 2


if __name__ == "__main__":
    print(function())