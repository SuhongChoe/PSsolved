import sys
input = sys.stdin.readline
output = sys.stdout.write

def function():
    # write code down
    # 나쁜 수열이 아니면서 가장 낮은 숫자를 출력해야함

    # input
    # 1. n : 숫자의 길이 1 <= n <= 80

    # output
    # 1. 나쁜 수열이 아니면서 가장 낮은 숫자

    # solution
    # 1. backtracking 구현
    # 2. 나쁜 수열인지 판단하는 함수 구현

    n = int(input())

    res = []

    backtracking(res, '', 0, n)
    
    return res[0]

def backtracking(res, seq, cnt, n):
    if not res:
        if cnt==n:
            res.append(seq)
        for num in '123':
            if good_seq(seq+num):
                backtracking(res, seq+num, cnt+1, n)

def good_seq(seq):
    # 1
    # -2 -1 [-2:-1] [-1:]
    # 2
    # -4 -3 -2 -1  [-4:-2] [-2:]
    # 3
    # -6 -5 -4 -3 -2 -1 [-6:-3] [-3:]
    
    mid = len(seq)//2
    for i in range(1, mid+1):
        if seq[-i*2:-i] == seq[-i:]:
            return False
    return True

if __name__ == "__main__":
    print(function())