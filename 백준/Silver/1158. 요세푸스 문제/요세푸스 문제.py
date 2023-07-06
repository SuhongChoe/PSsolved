from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 원을 이루며 앉음
    # k번째 사람을 제거함
    # rotate(-k) 하면서 dq.popleft()하면 될듯

    from collections import deque

    n, k = map(int, input().split())
    dq = deque(range(1, n+1))
    res = []

    for _ in range(n):
        dq.rotate(-(k-1))
        res.append(dq.popleft())

    return '<' + ', '.join(map(str, res)) + '>'
    
if __name__ == "__main__":
    print(str(function()))