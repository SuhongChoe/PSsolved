from sys import stdin, stdout
input=stdin.readline
# print=stdout.write

def function():
    # write down code

    # input
    # 1. m, n : 세로 가로 (1 <= m,n <= 500)
    # 2. h : 블록이 쌓인 높이

    # output
    # 고이는 빗물의 총량

    m, n = map(int, input().split())
    arr = list(map(int, input().split()))
    graph = [[0]*n for _ in range(m)]

    for i, h in enumerate(arr):
        for j in range(h):
            graph[j][i] = 1

    res = 0

    for i in range(m):
        try:
            s = graph[i].index(1)
            for j in range(n):
                if graph[i][j] == 1 and j != s:
                    # print(j - s - 1)
                    res += j - s - 1
                    s = j
        except:
            break

    return str(res)

    
if __name__ == "__main__":
    print(function())