import sys
input=sys.stdin.readline

def function():
    # write down code
    # 각 줄에 n개의 별을 찍는 문제

    res = ['*'*(i+1) for i in range(int(input()))]

    return '\n'.join(res)

if __name__ == "__main__":
    print(function())