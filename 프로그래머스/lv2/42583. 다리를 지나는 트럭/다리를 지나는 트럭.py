def solution(bridge_length, weight, truck_weights):
    # 순차적 일 작업을 해야함
    # 다리에는 트럭이 최대 bridge_length대 만큼 and
    # weight이하까지 트럭의 무게를 견딜 수 있음
    # 모든 트럭이 다리를 건너는 최소 시간을 return
    # 1 <= bridge_length <= 10000
    # 1 <= weight <= 10000
    # 1 <= truck_weights <= 10000
    # 1 <= truck_weights[i] <= weight
    
    # deque를 활용하여 다리의 무게나 개수가 초과한다면 조건이 될 때까지 트럭을 뺴는걸로 구현해야할듯
    
    # solution 
    # 0으로 채워서 하는게 10000*10000이라 1억 연산이라 괜찮은 방법이었음
    # 최적화가 더 가능할 것 같지만 복잡함
    
    from collections import deque
    
    crossing_trucks = deque([0]*bridge_length)
    bridge_weights = 0
    truck_weights.reverse()
    time = 0
    
    while truck_weights:
        bridge_weights -= crossing_trucks.pop()
        if bridge_weights + truck_weights[-1] <= weight: # 트럭 보낼 수 있는 경우
            bridge_weights += truck_weights[-1]
            crossing_trucks.appendleft(truck_weights.pop())
        else: # 트럭 내보낼 수 없는 경우
            crossing_trucks.appendleft(0) # shift 처리
        time += 1
        
    # 무조건 다리 첫번째 자리에 트럭이 오기때문에 다리 길이만큼 트럭 이동시간이 추가됨
    time += bridge_length
    
    return time