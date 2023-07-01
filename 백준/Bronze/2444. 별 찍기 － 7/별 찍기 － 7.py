from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # diamond 형태로 별이 찍힘
    # 2442 에서 했던 별 찍기를 뒤집었을 떄 [1:] 때랑 결합해서 출력하면 될듯

    # blank
    # i 층 -> n - i

    # star
    # i 층 -> 2*n-1

    n = int(input())
    res = [' '*(n-i) + '*'*(2*i-1) for i in range(1, n+1)]
    res = res + res[::-1][1:]

    return '\n'.join(res)
    
if __name__ == "__main__":
    print(function())