import sys
input=sys.stdin.readline
# print=sys.stdout.write

def function():
    # write down code

    from collections import defaultdict
    n = int(input())
    m = int(input())
    graph = defaultdict(list)
    for _ in range(m):
        a, b, cost = map(int, input().split())
        graph[a].append((cost, b))

    start, end = map(int, input().split())
    costs = {i:sys.maxsize for i in range(1, n+1)}
    costs[start] = 0

    dijkstra(start, graph, costs)

    return str(costs[end])

def dijkstra(start, graph, costs):
    import heapq
    heap = []

    heapq.heappush(heap, (costs[start], start))

    while heap:
        cost, node = heapq.heappop(heap)

        if costs[node] < cost:
            continue

        for next_cost, next_node in graph[node]:
            nc = cost+next_cost
            if costs[next_node] > nc:
                costs[next_node] = nc
                heapq.heappush(heap, (nc, next_node))


if __name__ == "__main__":
    print(function())