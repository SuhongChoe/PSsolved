import sys

def solution():
    input = sys.stdin.readline

    a = 1
    b = 2
    c = int(input())
    for i in range(3,c+1):
        c = (a + b) % 15746
        a, b = b, c

    print(c)
solution()
