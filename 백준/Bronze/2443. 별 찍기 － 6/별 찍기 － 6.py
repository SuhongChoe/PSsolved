from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 2442 에서 역순 임
    # star
    # i 층 -> 2*i-1

    # blank
    # i 층 -> n - i

    n = int(input())
    res = [' '*(n-i) + '*'*(2*i-1) for i in range(1, n+1)][::-1]

    return '\n'.join(res)
    
if __name__ == "__main__":
    print(function())