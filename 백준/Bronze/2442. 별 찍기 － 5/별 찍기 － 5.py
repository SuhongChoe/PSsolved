from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 층별로 피라미드 형태로 별을 출력해야함
    # star
    # i층 -> 2*i-1개

    # blank(star 왼쪽 기준 개수)
    # i층 -> n - i
    n = int(input())

    res = [' '*(n-i) + '*'*(2*i-1) for i in range(1, n+1)]

    return '\n'.join(res)
    
if __name__ == "__main__":
    print(function())