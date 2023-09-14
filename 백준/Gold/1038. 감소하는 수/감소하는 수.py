import sys
input = sys.stdin.readline
print = sys.stdout.write

def function():
    # write code down
    # 9752 이런식이면 감소하는 수
    # 9663 이런식이면 아님
    # n 번째 감소하는 수를 출력
    # 0 은 0번째 감소하는 수
    # 1은 1번째 감소하는 수

    # input
    # 1. n : n번째 감소하는 수 0 <= n <= 1000000

    # output
    # 1. n번째 감소하는 수 출력 감소하는 수가 없다면 -1 출력   

    n = int(input())
    
    res = bfs()

    try:
        return str(res[n])
    except:
        return str(-1)

def bfs():
    from collections import deque

    q = deque(i for i in '0123456789')
    res = []

    while q:
        n = q.popleft()
        res.append(n)
        
        for i in range(int(n[-1])):
            new_s = str(i)
            if n[-1] > new_s:
                q.append(n+new_s)
            
    return res

if __name__ == '__main__':
    print(function())