import sys
input = sys.stdin.readline
print = sys.stdout.write

def function():
    # write code down

    v, e = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(e)]
    arr.sort(key=lambda x: x[2])
    parent = [i for i in range(v+1)]

    res = kruskal(arr, parent)
    
    return str(res)

def kruskal(arr, parent):
    res = 0
    for a, b, cost in arr:
        res += union(parent, a, b, cost)

    return res
        
def union(parent, a, b, cost):
    aroot = find(parent, a)
    broot = find(parent, b)

    res = 0

    if aroot != broot:
        if aroot < broot:
            parent[aroot] = broot
        else:
            parent[broot] = aroot
        res = cost

    return res

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

if __name__ == '__main__':
    print(function())