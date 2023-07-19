from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 컴비네이션 쓰면 될듯?

    from itertools import combinations

    res = []

    while True:
        n, *S = map(int, input().split())
        if n == 0:
            break
        S.sort()

        s = list(map(lambda x: ' '.join(map(str, x)), combinations(S, 6))) + ['']

        res += s

    return '\n'.join(res)
    
if __name__ == "__main__":
    print(function())