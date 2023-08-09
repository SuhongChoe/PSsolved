import sys
input = sys.stdin.readline
output = sys.stdout.write

def function():
    # write code down
    
    # input 형태
    # 1. n 회의 수
    # 2~. 회의가 시작하고 끝나느 시간 0 <= time <= 2^31-1
    
    # return : 최대 사용할 수 있는 회의의 최대 개수

    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(n)]

    arr.sort(key=lambda x: (x[1], x[0]))

    res = 1
    end_time = arr[0][1]
    for i in range(1, n):
        start_time = arr[i][0]
        if end_time <= start_time:
            res+=1
            end_time = arr[i][1]
    
    return str(res)

if __name__ == "__main__":
    print(function())