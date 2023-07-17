def solution(bridge_length, weight, truck_weights):
    # 최악일때 만*만 이라서 1억번임 ㄱㅊ
    
    from collections import deque
    
    bridge = deque([0]*bridge_length) # bridge_length 만큼 다리 생성
    truck_weights.reverse()
    total_weights = 0
    res = 0
    
    while truck_weights:
        total_weights -= bridge.popleft()
        if total_weights + truck_weights[-1] <= weight:
            truck = truck_weights.pop()
            bridge.append(truck)
            total_weights += truck
        else:
            bridge.append(0)
        res += 1
    
    res += bridge_length
    
    return res