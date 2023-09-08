import sys
input = sys.stdin.readline
print = sys.stdout.write

# def function():
#     # write code down
#
#     from collections import defaultdict
#
#     n = int(input())
#     m = int(input())
#     graph = defaultdict(list)
#     for _ in range(m):
#         a, b, distance = map(int, input().split())
#         graph[a].append((distance, b))
#     start, end = map(int, input().split())
#
#     d = {i:sys.maxsize for i in range(1, n+1)}
#     d[start] = 0
#
#     dijkstra(graph, d, start)
#
#     return str(d[end])
#
# def dijkstra(graph, d, start):
#     import heapq
#
#     heap = [(d[start],start)]
#
#     while heap:
#         distance, node = heapq.heappop(heap)
#
#         if d[node] < distance:
#             continue
#
#         for cost, next_node in graph[node]:
#             new_cost = cost + distance
#             if d[next_node] > new_cost:
#                 d[next_node] = new_cost
#                 heapq.heappush(heap, (new_cost, next_node))

def function():
    # write code down
    # 도시의 번호 1~n

    # input
    # 1. n : 도시의 개수 (1 <= n <= 1000)
    # 2. m : 버스의 개수 (1 <= m <= 100000)
    # 3~m+2. a, b, distance : 비용 (0 <= distance < 100000)
    # m+3. start, end : 출발점 도착점 도시 번호

    # output
    # 출발점에서 도착점까지의 최소비용
    global n, m, graph, costs

    from collections import defaultdict

    n = int(input())
    m = int(input())
    graph = defaultdict(list)
    for _ in range(m):
        a, b, distance = map(int, input().split())
        graph[a].append((distance, b))

    start, end = map(int, input().split())

    costs = [1e8]*(n+1)
    costs[start] = 0

    dijkstra(start)

    return str(costs[end])

def dijkstra(start):
    global n, m, graph, costs

    import heapq

    q = [(0, start)]

    while q:
        distance, node = heapq.heappop(q)

        if distance > costs[node]:
            continue

        for next_distance, next_node in graph[node]:
            new_distance = distance + next_distance

            if costs[next_node] > new_distance:
                costs[next_node] = new_distance
                heapq.heappush(q, (new_distance, next_node))

if __name__ == '__main__':
    print(function())