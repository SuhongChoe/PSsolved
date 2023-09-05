from sys import stdin, stdout
input=stdin.readline
print=stdout.write

# def dfs(arr, idx, s, res, n):
#     if n == idx:
#         return
#     if s-arr[idx] == 0:
#         res[0] += 1
#     dfs(arr, idx+1, s-arr[idx], res, n)
#     dfs(arr, idx+1, s, res, n)

def function():
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

    res = [0]

    backtracking(arr, s, 0, n, res)

    return str(res[0])

def backtracking(arr, s, i, n, res):
    if i == n:
        return

    s -= arr[i]

    if s == 0:
        res[0] += 1

    backtracking(arr, s+arr[i], i+1, n, res)
    backtracking(arr, s, i+1, n, res)


if __name__ == "__main__":
    print(function())