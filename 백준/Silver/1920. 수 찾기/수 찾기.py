from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # n 개의 배열에서 x가 존재하는지 return (존재 : 1
    # 각각의 배열이 10만개 이기에 단순서칭하면 100억 연산됨 이기에 2^32 즉 다 뒤져본다면 40억 연산됨
    # 따라서 정렬 후에 이분탐색으로 서치하면 됨

    res = []

    n = int(input())
    arr = list(map(int, input().split()))
    arr.sort()

    m = int(input())
    for x in map(int, input().split()):
        l, r = 0, n-1
        ok = 0
        while l<=r:
            mid = (l+r)//2

            if arr[mid]<x: # l을 늘려야함
                l = mid + 1
            elif arr[mid]>x: # r을 줄어야함
                r = mid - 1
            else: # 정답일 때
                ok = 1
                break
                
        res.append(ok)

    return '\n'.join(map(str, res))
    
if __name__ == "__main__":
    print(str(function()))