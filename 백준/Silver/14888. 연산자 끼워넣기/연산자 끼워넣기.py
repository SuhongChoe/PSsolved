from sys import stdin, stdout
input=stdin.readline
# print=stdout.write

def function():
    # write down code
    # 수 사이에 연산자를 넣어 수식을 만들고 나온 계산결과가 최대, 최소 구하기

    # input
    # 1. n : 수의 개수 (2 <= n <= 11)
    # 2. arr : 수열 (1 <= arr[i] <= 100) (수의 순서는 고정)
    # 3. op : 연산자 (+,-,x,/) (식의 계산은 무조건 앞에서부터 진행, 나눗셈은 몫만 취함)

    # solution
    # 완전탐색으로 푼다면 연산자를 순열로 입력해야하므로 10! == 3628800 가능

    n = int(input())
    arr = list(map(int, input().split()))
    oper = list(map(int, input().split()))

    res = [-1e+9-1, 1e+9+1]

    dfs(arr, oper, 1, arr[0], res, n)

    return '\n'.join(map(str, res))

def dfs(arr, oper, idx, n, res, l):
    if idx == l:
        res[0], res[1] = max(res[0], n), min(res[1], n)
        return

    for i in range(4):
        if oper[i]>0:
            oper[i]-=1
            if i==0:
                dfs(arr, oper, idx + 1, n+arr[idx], res, l)
            elif i==1:
                dfs(arr, oper, idx + 1, n-arr[idx], res, l)
            elif i==2:
                dfs(arr, oper, idx + 1, n*arr[idx], res, l)
            else:
                dfs(arr, oper, idx + 1, int(n/arr[idx]), res, l)
            oper[i]+=1
    
if __name__ == "__main__":
    print(function())