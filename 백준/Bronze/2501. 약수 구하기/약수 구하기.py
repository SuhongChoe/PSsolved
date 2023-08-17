import sys
input = sys.stdin.readline
print = sys.stdout.write

def function():
    # write code down
    # n의 약수들 중 k 번째로 작은 수 출력

    # input
    # n, k : 자연수, 약수의 위치 (1 <= n <= 10000, 1 <= k <= n)

    # output
    # 약수 (단, 존재하지 않으면 0을 출력)

    n, k = map(int, input().split())

    for i in range(1, n+1):
        if n%i==0:
            k-=1
        if k==0:
            return str(i)
    
    return str(0)

if __name__ == '__main__':
    print(function())