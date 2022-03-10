import sys
from collections import defaultdict, deque

def solution():
    global Map, check_map
    input = sys.stdin.readline

    N, M, V = map(int,input().split())
    Map = defaultdict(list)
    for n in range(M):
        s, e = map(int, input().split())
        Map[s].append(e)
        Map[e].append(s)

    for k, v in Map.items():
        Map[k] = sorted(v)

    def DFS(start):
        if len(check_map)==len(Map):
            return
        for i in Map[start]:
            if not i in check_map:
                print(i,end=' ')
                check_map.add(i)
                DFS(i)
    print(V, end=' ')
    check_map = set([V])
    DFS(V)
    print()
    
    def BFS(start):
        q = deque()
        q += Map[start]
        while q:
            n = q.popleft()
            if not n in check_map:
                print(n,end=' ')
                check_map.add(n)
                q += Map[n]
    print(V, end=' ')
    check_map = set([V])
    BFS(V)

solution()
