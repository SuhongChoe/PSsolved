from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 1. push
    # 2. pop
    # 주의 : 파이썬은 힙이 최소 힙

    import heapq
    heap = []
    res = []

    for _ in range(int(input())):
        x = int(input())

        if x == 0: # pop
            n = -heapq.heappop(heap) if heap else 0
            res.append(n)
        else: # push
            heapq.heappush(heap, -x)

    return '\n'.join(map(str, res))
    
if __name__ == "__main__":
    print(str(function()))