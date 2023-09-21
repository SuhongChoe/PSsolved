import sys
input = sys.stdin.readline
print = sys.stdout.write

def function():
    # write code down

    # input
    # 1. a, b : 시작 숫자, 목표 숫자 (1 <= a < b <= 1e9)

    # output
    # 1. a -> b 가 되는데 최소연산 + 1 (단, 만들 수 없는 경우는 -1 출력)

    a, b = map(int, input().split())

    res = 1

    while a<b:
        if b%10==1:
            b//=10
        elif b%2==0:
            b//=2
        else:
            break
        res += 1

    res = res if a == b else -1
    
    return str(res)

if __name__ == '__main__':
    print(function())