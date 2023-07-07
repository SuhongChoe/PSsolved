def solution(prices):
    # 문제의 핵심은 가격과 위치정보가 필요하다는 것과
    # prices의 길이가 100000이라는 것
    # 따라서 스택을 활용한 이전가격과 비교하여 얼만큼의 추세길이를 가지고있는지 확인하는 방법이 중요
    
    res = [0]*len(prices)
    len_prices = len(prices)
    s = []
    
    for i, p in enumerate(prices):
        while s and s[-1][1] > prices[i]:
            past, _ = s.pop()
            res[past] = i - past
        s.append((i, p))
    for i, p in s:
        res[i] = len_prices - i - 1
    
    return res