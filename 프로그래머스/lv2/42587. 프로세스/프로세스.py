def solution(priorities, location):
    # 특정 프로세스가 몇 번째로 실행됐는지 return
    # 다음과 같은 규칙으로 프로세스를 관리함
    # 1. 대기 큐에서 프로세스를 꺼냄
    # 2. 대기 큐에서 우선순위가 더 높은 프로세스가 있다면 꺼낸 프로세스를 다시 큐에 넣음
    # 3. 없다면 프로세스 실행 후 넣지 않음
    
    # deque를 활용하여 rotate 후 빠는 과정 반복
    
    from collections import deque

    priorities = deque(priorities)
    locations = deque(range(len(priorities)))
    
    res = 0
    
    while priorities:
        res += 1
        
        cnt_rotate = priorities.index(max(priorities))
        priorities.rotate(-cnt_rotate)
        locations.rotate(-cnt_rotate)
        
        priorities.popleft()
        if locations.popleft() == location:
            break
        
    return res