from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def old_function():
    # write down code
    # 일직선 상에서 수빈이와 동생이 위치함
    # 수빈 -> n
    # 동생 -> k
    # 수빈이가 동생을 찾아야 함
    # 방법 두가지 떠오름
    # 둘다 십만개 이기 떄문에
    # dfs로 풀면 게속 반복함
    # 따라서 bfs로 풀거나
    # dp로 풀거나

    n, k = map(int, input().split())
    # dp로 풀 경우
    # import sys
    #
    # dp = [sys.maxsize]*100001
    # dp[n] = 0
    # for i in range(n-1, -1, -1):
    #     dp[i] = dp[i+1] + 1
    #
    # for i in range(100001):
    #     tmp = sys.maxsize
    #     if 0 <= i+1 <=100000:
    #         tmp = min(tmp, dp[i+1])
    #     if 0 <= i-1 <=100000:
    #         tmp = min(tmp, dp[i-1])
    #     if i%2==0:
    #         tmp = min(tmp, dp[i//2])
    #     dp[i] = min(dp[i], tmp + 1)
    #
    # return dp

    # bfs로 풀 경우
    from collections import deque
    q = deque([(n, 0)])
    visited = [False]*100001
    visited[n] = True

    while q:
        new_n, cnt = q.popleft()

        if new_n == k:
            return cnt

        # 아래의 코드를 깔끔하게 바꿀 수 있다.
        # if 0 <= new_n - 1 <= 100000 and not visited[new_n - 1]:
        #     q.append((new_n - 1, cnt + 1))
        #     visited[new_n - 1] = True
        # if 0 <= new_n + 1 <= 100000 and not visited[new_n + 1]:
        #     q.append((new_n + 1, cnt + 1))
        #     visited[new_n + 1] = True
        # if 0 <= new_n * 2 <= 100000 and not visited[new_n * 2]:
        #     q.append((new_n * 2, cnt + 1))
        #     visited[new_n * 2] = True

        # 이렇게 말이다
        for next_n in (new_n - 1, new_n + 1, new_n * 2):
            if 0 <= next_n <= 100000 and not visited[next_n]:
                q.append((next_n, cnt + 1))
                visited[next_n] = True


def function():
    # 수빈이의 위치 N
    # 동생 K
    # 수빈이 보법
    # 1. X + 1
    # 2. X - 1
    # 3. 2*X
    # return N -> K 최소시간

    from collections import deque
    import sys

    n, k = map(int, input().split())

    d = [sys.maxsize]*100001
    d[n] = 0
    q = deque([n])

    while q:
        x = q.popleft()

        for next_x in [x-1, x+1, x*2]:
            if 0 <= next_x <= 100000 and d[x]+1<d[next_x]:
                d[next_x] = d[x]+1
                q.append(next_x)

    return d[k]

if __name__ == "__main__":
    print(str(function()))