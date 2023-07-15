def solution(bridge_length, weight, truck_weights):
    # 트럭은 최대 bridge_length대 and weight 이하 무게까지 견딜 수 있음
    # return 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지
    
    from collections import deque
    
    bridge = deque([0]*bridge_length)
    truck_weights.reverse()
    truck_on_bridge_w = 0
    res = 0
    
    while truck_weights:
        truck_on_bridge_w -= bridge.popleft()
        if truck_on_bridge_w + truck_weights[-1] > weight:
            bridge.append(0)
        else: # 건널 수 있을 땐
            truck = truck_weights.pop()
            truck_on_bridge_w += truck
            bridge.append(truck)
        res += 1
    
    res += bridge_length
    
    return res