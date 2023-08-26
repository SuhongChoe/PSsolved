from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 최대 공약수와 최소 공배수를 출력

    a, b = map(int, input().split())

    res = [gcd(a, b), a*b//gcd(a, b)]

    return '\n'.join(map(str, res))

def gcd(a, b):
    if a<b:
        return gcd(b, a)

    while b!=0:
        r = a % b
        a, b = b, r
    return a

if __name__ == "__main__":
    print(function())