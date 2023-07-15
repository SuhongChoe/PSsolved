from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 상근이는 숫자 카드 n개를 가지고 있다.
    # 해당 카드가 몇 개 인지 구하는 프로그램

    # solution 1
    # Counter쓰면 될듯

    from collections import Counter

    n = int(input())
    arr = list(map(int, input().split()))
    cnt_arr = Counter(arr)


    m = int(input())
    res = [cnt_arr[x] for x in map(int, input().split())]

    return ' '.join(map(str, res))
    
if __name__ == "__main__":
    print(function())