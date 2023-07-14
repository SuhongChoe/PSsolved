from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 홀수번째 읽을 때 마다 중앙 값을 출력하는 프로그램 작성

    # left (최대힙)
    # right (최소힙)
    # middle 출력해야하는 중앙값

    # 홀수와 짝수일떄로 나뉨
    # 홀수 일때 0 2 4 6...
    # n이 남고
    # 짝 수 일떄 1 3 5 7
    # 다들어가야함

    # solution 1
    # 1. 중앙값과 비교해서 들어올 숫자를 힙에 저장
    # 2. 만약 홀수번쨰 라면 길이를 맞춰야 하기에 길이가 틀린 경우는 2개가 차이남
    # 2-1. 이러한 경우는 mid를 길이가 작은 쪽으로 push
    # 2-2. 길이가 큰쪽을 pop 하여 mid로 지정하면 끝

    import heapq

    T = int(input())

    res = []

    for _ in range(T):
        arr = []
        m = int(input())
        for _ in range(m//10+1):
            arr += list(map(int, input().strip().split())) # 10개씩 받기 위함

        t = [arr[0]]

        left_heap = []
        right_heap = []
        mid = arr[0]

        for i in range(1, m):
            n = arr[i]
            if mid > n: # 중앙값 보다 작은 경우
                heapq.heappush(left_heap, -n)
            else: # 중앙값 보다 큰 경우
                heapq.heappush(right_heap, n)

            if i%2==0: # 홀수 번쨰 일떄 마다 실행
                if len(left_heap) > len(right_heap): # left가 right보다 두개 많음
                    heapq.heappush(right_heap, mid)
                    mid = -heapq.heappop(left_heap)
                elif len(left_heap) < len(right_heap): # right가 left보다 두개 많음
                    heapq.heappush(left_heap, -mid)
                    mid = heapq.heappop(right_heap)
                t.append(mid)

        res.append(str(len(t)))

        mini_res = ''
        for i in range(len(t)):
            if i%10 == 0:
                mini_res += '\n'
            mini_res += str(t[i]) + ' '

        res.append(mini_res.strip())

    return '\n'.join(res)
    
if __name__ == "__main__":
    # function()
    print(str(function()).strip())