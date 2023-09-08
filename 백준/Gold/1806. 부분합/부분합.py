from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write code down

    n, s = map(int, input().split())
    arr = list(map(int, input().split()))

    res = 100001
    cur_sum = 0
    start = 0

    for end in range(n):
        cur_sum += arr[end]
        while start <= end and s <= cur_sum:
            res = min(res, end - start + 1)
            cur_sum -= arr[start]
            start += 1

    if res==100001:
        res = 0

    return str(res)
if __name__=='__main__':
    print(function())