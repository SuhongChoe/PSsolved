from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 층에 해당하는 별을 역순으로 출력하는데 오른쪽 정렬을 한 것을 출력
    n = int(input())
    res = [('*'*i).rjust(n, ' ') for i in range(1, n+1)][::-1]

    return '\n'.join(res)
    
if __name__ == "__main__":
    print(function())