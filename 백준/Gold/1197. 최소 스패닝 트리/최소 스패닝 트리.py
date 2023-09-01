import sys
input = sys.stdin.readline
print = sys.stdout.write

def function():
    # write code down

    v, e = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(e)]
    arr.sort(key=lambda x: x[2])
    parent = [i for i in range(v+1)]
    res = [0]

    kruskal(arr, parent, res)
    
    
    return str(res[0])

def kruskal(arr, parent, res):
    for a, b, cost in arr:
        union(parent, a, b, cost, res)

    return
        
def union(parent, a, b, cost, res):
    aroot = find(parent, a)
    broot = find(parent, b)

    if aroot != broot:
        if aroot < broot:
            parent[aroot] = broot
        else:
            parent[broot] = aroot
        res[0] += cost

    return

def find(parent, x):
    if parent[x] == x:
        return x
    parent[x] = find(parent, parent[x])
    return parent[x]

if __name__ == '__main__':
    print(function())