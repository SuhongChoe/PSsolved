from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 1. n : 회의의 수 1 <= n <= 100000
    # 2~. start, end : 회의의 시작시간 끝나는 시간

    n = int(input())
    schedule = [list(map(int, input().split())) for _ in range(n)]

    schedule.sort(key=lambda x: (x[1], -(x[1]-x[0])))

    end = schedule[0][1]
    res = 1

    for i in range(1, n):
        next_s, next_e = schedule[i]
        if end <= next_s:
            end = next_e
            res += 1

    return str(res)
    
if __name__ == "__main__":
    print(function())