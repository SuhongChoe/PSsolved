import sys;input = sys.stdin.readline

def binary():
    global n
    l = 1
    r = max(ll)
    d = 0
    while l <= r:
        ans = (l + r) // 2
        cnt = 0
        for j in ll:
            cnt += j // ans
        if n > cnt:
            r = ans - 1
        else:
            l = ans + 1
            d = ans
    return d

k, n = map(int, input().split())
ll = [ int(input().strip()) for i in range(k)]
print(binary())