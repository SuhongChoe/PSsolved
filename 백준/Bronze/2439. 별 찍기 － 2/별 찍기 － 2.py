from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 각 층의 층수만큼 *을 오른쪽 정렬을 해야함

    n = int(input())
    res = [' '*(n-1-i) + '*'*(i+1) for i in range(n)]

    return '\n'.join(res)
    
if __name__ == "__main__":
    print(function())