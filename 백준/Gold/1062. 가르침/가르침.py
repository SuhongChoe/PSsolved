import sys
input = sys.stdin.readline
print = sys.stdout.write

def function():
    # write code down

    # input
    # 1. n, k : 주어진 단어, 가르칠 수 있는 글자 (1 <= n <= 50, 0 <= k <= 26)
    # 2~. arr[i] : 단어들

    # output
    # 1. 단어 개수의 최대값

    global arr, res

    n, k = map(int, input().split())
    arr = [set(input().strip()) for _ in range(n)]

    res = 0

    if k < 5:
        return str(0)
    elif k == 26:
        return str(n)

    learned = set('antic')
    k -= 5

    backtracking(ord('a'), learned, k)

    return str(res)

def backtracking(start, learned, k):
    global arr, res

    if k == 0:
        cnt = 0
        for s in arr:
            if not s - learned:
                cnt += 1

        res = max(res, cnt)

        return

    for i in range(start, ord('z')+1):
        c = chr(i)
        if not c in learned:
            learned.add(c)
            backtracking(i+1, learned, k-1)
            learned.remove(c)

if __name__ == '__main__':
    print(function())