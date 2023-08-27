from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 구간의 합을 리턴

    # input
    # 1. A, B : 시작과 끝을 나타내는 정수 (1 <= A <= B <= 1000)

    # output
    # A~B 위치에 해당하는 숫자의 합

    a, b = map(int, input().split())

    arr = [0, 1]

    for i in range(2, int(1000*0.5)+1):
        for j in range(i):
            arr.append(arr[-1]+i)

    return str(arr[b]-arr[a-1])
    
if __name__ == "__main__":
    print(function())