from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # n -> 수업 갯수
    # s t -> 수업시간

    # 누적합이면 좋을 듯

    from collections import defaultdict

    dic = defaultdict(int)

    for _ in range(int(input())):
        s, t = map(int, input().split())
        dic[s] += 1
        dic[t] -= 1

    keys = sorted(dic.keys())

    res = 0
    classroom = 0

    
    for k in keys:
        classroom += dic[k]
        res = max(res, classroom)

    return str(res)
    
if __name__ == "__main__":
    print(function())
