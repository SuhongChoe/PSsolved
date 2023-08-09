import sys
input = sys.stdin.readline
output = sys.stdout.write

def function():
    # write code down
    # input
    # 1. n 카드개수 1 <= n <= 1000
    # 2. 카드의 레벨 0 <= Li <= 100000

    # solution
    # 합성을 하면 돈이 줄기에 최대한 작은 카드를 합성하는 것이 좋다.
    # 그렇다면 내림차순으로 정렬하여 점점 내려가는 식으로 해야할듯
    
    n = int(input())
    arr = list(map(int, input().split()))
    arr.sort(reverse=True)

    res = sum(map(lambda x: x+arr[0], arr[1:]))
    
    return str(res)

if __name__ == "__main__":
    print(function())