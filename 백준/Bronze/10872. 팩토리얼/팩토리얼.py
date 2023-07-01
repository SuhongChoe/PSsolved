from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # factorial 문제
    # dp 로 구현 할것임

    # stdout.write 는 str만을 반환해야함!!!!!!!!!

    d = [1]*13
    for i in range(1, 13):
        d[i] = d[i - 1] * i

    n = int(input())

    return str(d[n])
    
if __name__ == "__main__":
    print(function())