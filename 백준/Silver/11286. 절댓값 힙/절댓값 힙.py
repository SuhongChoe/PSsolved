from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 절대값 힙이래

    # 1. 0을 제외한 정수를 넣음 (0은 pop) (나머지 정수 push)
    # 2. 절대값 최소힙 (단, 절대값이 가장 작은 값이 여러개일 떄는, 가장 작은수를 출력)

    # heap에 넣을떄 (abs, origin) 넣으면 될듯

    import heapq

    heap = []
    res = []

    for _ in range(int(input())):
        x = int(input())

        if x == 0: # pop
            _, n = heapq.heappop(heap) if heap else (0, 0)
            res.append(n)
        else: # push
            heapq.heappush(heap, (abs(x), x))

    return '\n'.join(map(str, res))
    
if __name__ == "__main__":
    print(str(function()))