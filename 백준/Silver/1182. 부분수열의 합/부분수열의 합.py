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

# def function():
#     # write down code
#     # 1. n, s : 정수의 개수, 부분수열 중 원소를 다 더한 값 s, 1 <= n <= 20, |s| <= 1000000
#     # 2. arr

#     # solution

#     res = [0]

#     n, s = map(int, input().split())
#     arr = list(map(int, input().split()))
#     arr.sort()

#     dfs(arr, 0, s, res, n)

#     return str(res[0])

def function():
    # write code down
    # 부분적으로 원소를 더했을 때 S가 되는 경우의 수 출력

    # input
    # 1. n, s : 정수의 개수, target (1 <= n <= 20, |s| <= 1000000)
    # 2. arr : 주어진 배열 (|arr[i]| <= 100000)
    
    # output
    # s가 되는 경우의 수

    n, s = map(int, input().split())
    arr = list(map(int, input().split()))
    arr.sort()
    res = [0]

    dfs(arr, 0, n, s, res)

    return str(res[0])

def dfs(arr, i, n, s, res):
    if i == n:
        return
        
    s -= arr[i]
    
    if s==0:
        res[0] += 1
    
    dfs(arr, i+1, n, s+arr[i], res)
    dfs(arr, i+1, n, s, res)

if __name__ == "__main__":
    print(function())