import sys

def solution():
    input = sys.stdin.readline

    a = 1
    b = 2
    n = int(input())
    c = 0 if n>2 else n
    for i in range(3,n+1):
        c = (a + b) % 15746
        a, b = b, c

    print(c)
solution()
