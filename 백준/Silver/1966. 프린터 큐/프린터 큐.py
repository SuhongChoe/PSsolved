from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # pg 프로세스와 동일한 문제이다.
    # 그대로 풀어도 될듯?
    from collections import deque

    res = []

    for _ in range(int(input())):
        n, location = map(int, input().split())
        docs = deque(map(int, input().split()))
        sort_docs = sorted(docs) # 문서 중요도 정보
        locations = deque(range(n)) # 위치 정보
        cnt = 0 # 처리 횟수

        while docs:
            # 문서 정리
            cnt_rotate = docs.index(sort_docs.pop())
            docs.rotate(-cnt_rotate)
            locations.rotate(-cnt_rotate)

            # 문서 처리
            cnt += 1
            docs.popleft()
            if locations.popleft() == location:
                res.append(cnt)

    return '\n'.join(map(str, res))
    
if __name__ == "__main__":
    print(str(function()))