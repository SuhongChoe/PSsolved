def solution(prices):
    # 현재 보는 가격보다 이전가격이 큰 경우 그때 초기화됨
    # stack에 저장하면서 위치 정보와 같이 저장함
    
    s = []
    n = len(prices)
    res = [0]*n
    
    for i, p in enumerate(prices):
        idx = (n-i)-1
        while s and s[-1][0] > p:
            before_price, before_idx = s.pop()
            res[n-before_idx-1] = before_idx-idx
        s.append((p, idx))
    
    while s:
        price, idx = s.pop()
        res[n-idx-1] = idx
        
    return res