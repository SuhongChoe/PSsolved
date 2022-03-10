import sys

def solution():
    input = sys.stdin.readline

    d = range(10001)
    check_d = [0]*len(d)

    for i in range(1,len(d)):
        if check_d[i]==0:
            print(d[i])
        number = i
        temp = 0
        while number>0:
            temp += number%10
            number //= 10
        try:
            check_d[i + temp] = 1
        except:
            pass

solution()
