from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # n, n-1, ... 1개 되도록 층에 해당하는 별을 출력해야함
    res = ['*'*i for i in range(1, int(input())+1)][::-1]

    return '\n'.join(res)
    
if __name__ == "__main__":
    print(function())