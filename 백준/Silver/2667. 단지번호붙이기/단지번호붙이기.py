import sys
from collections import deque

def solution():
    input = sys.stdin.readline
    # 상, 하 , 좌, 우
    dx = [0,0,-1,1]
    dy = [-1,1,0,0]

    n = int(input())

    Map = [list(map(int,input().strip())) for _ in range(n)]

    check_map = [list(map(lambda x : True if x==1 else False,i)) for i in Map]

    answers = []

    def BFS(y, x):
        q = deque()
        q.append((y,x))
        check_map[y][x]=False
        answer = 1
        while q:
            y, x = q.popleft()
            for i in range(4):
                new_y = y+dy[i]
                new_x = x+dx[i]
                if 0<=new_y<n and 0<=new_x<n and check_map[new_y][new_x]:
                    q.append((new_y,new_x))
                    check_map[new_y][new_x]=False
                    answer += 1
        answers.append(answer)

    for i in range(n):
        for j in range(n):
            if check_map[i][j]:
                BFS(i,j)
    print(len(answers))
    for answer in sorted(answers): print(answer)

solution()
