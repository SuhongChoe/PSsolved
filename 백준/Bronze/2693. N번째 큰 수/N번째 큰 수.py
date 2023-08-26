from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # input
    # 1. T
    # 2~. 10개의 원소로 이루어진 배열

    # output
    # 배열 3번째 큰 값을 출력

    res = []
    for _ in range(int(input())):
        arr = list(map(int, input().split()))
        arr.sort()

        res.append(arr[-3])

    return '\n'.join(map(str, res))
    
if __name__ == "__main__":
    print(function())