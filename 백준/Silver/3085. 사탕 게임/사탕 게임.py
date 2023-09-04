import sys
input=sys.stdin.readline
# print=sys.stdout.write

# def function():
#     # write down code
#     # (n-1)*n*n*2
#
#     n = int(input())
#     graph = [list(input().strip()) for _ in range(n)]
#
#     res = eat_count(graph, n)
#
#     for i in range(n):
#         for j in range(n):
#             if j+1 < n:
#                 graph[i][j], graph[i][j+1] = graph[i][j+1], graph[i][j]
#                 res = max(res, eat_count(graph, n))
#                 graph[i][j], graph[i][j+1] = graph[i][j+1], graph[i][j]
#
#             if i+1 < n:
#                 graph[i][j], graph[i+1][j] = graph[i+1][j], graph[i][j]
#                 res = max(res, eat_count(graph, n))
#                 graph[i][j], graph[i+1][j] = graph[i+1][j], graph[i][j]
#
#     return str(res)
#
# def eat_count(graph, n):
#     res = 0
#
#     for i in range(n):
#         cnt = 1
#         for j in range(1, n): # 열
#             if graph[i][j] == graph[i][j-1]:
#                 cnt += 1
#             else:
#                 cnt = 1
#             res = max(cnt, res)
#
#         cnt = 1
#         for j in range(1, n): # 행
#             if graph[j][i] == graph[j-1][i]:
#                 cnt += 1
#             else:
#                 cnt = 1
#             res = max(cnt, res)
#
#     return res

def function():
    # write code down

    n = int(input())
    graph = [list(input().strip()) for _ in range(n)]

    dx = [0,0,1,-1]
    dy = [1,-1,0,0]

    res = 0

    for y in range(n):
        for x in range(n):
            for k in range(4):
                ny, nx = dy[k]+y, dx[k]+x
                if 0 <= ny < n and 0 <= nx < n:
                    graph[y][x], graph[ny][nx] = graph[ny][nx], graph[y][x]

                    t = 0
                    while y+t < n and graph[y][x]==graph[y+t][x]:
                        t+=1

                    d = 0
                    while y-d >= 0 and graph[y][x]==graph[y-d][x]:
                        d+=1

                    r = 0
                    while x+r < n and graph[y][x]==graph[y][x+r]:
                        r+=1

                    l = 0
                    while x-l >= 0 and graph[y][x]==graph[y][x-l]:
                        l+=1

                    graph[y][x], graph[ny][nx] = graph[ny][nx], graph[y][x]

                    res = max(res, t+d-1, r+l-1)

    return str(res)

if __name__ == "__main__":
    print(function())