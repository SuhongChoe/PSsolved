from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    global n, res, arr
    # write code down
    # 수열 안의 원소들의 합으로 s를 만들 수 있는 경우의 수

    # input
    # 1. n, s : 정수의 개수, 만들고자하는 수 (1 <= n <= 20, |S| <= 1000000)
    # 2. arr : 수열 ( |arr[i]| <= 100000)

    # output
    # 1. 만들 수 있는 부분수열의 개수

    n, s = map(int, input().split())
    arr = list(map(int, input().split()))
    arr.sort()

    res = 0

    backtracking(s, 0)

    return str(res)

def backtracking(s, i):
    global n, res, arr
    
    if i == n:
        return

    if s - arr[i] == 0:
        res += 1

    backtracking(s-arr[i], i+1)
    backtracking(s, i+1)


if __name__ == "__main__":
    print(function())