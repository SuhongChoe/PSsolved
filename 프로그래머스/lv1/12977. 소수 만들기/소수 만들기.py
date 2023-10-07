def isprime(n):
    for i in range(2, int(n**0.5+1)):
        if n%i==0:
            return False
            
    return True
        

def solution(nums):
    # nums에서 숫자 3개를 골라 더했을 때 소수가 되는 경우
    # 3개 고르는 연산은 최대 50C3으로 매우 적다
    # 소수 판별은 root(n)+1 까지 해봤을 나누어지는 숫자가 있는지 보면 됨
    # 혹은 에스테라 채 구현해서 3000 까지 한번에 따딱 하면 될듯한데 이거는 뭔지 모르겠다
    
    from itertools import combinations
    
    arr = list(map(sum, combinations(nums, 3)))
    
    res = 0
    for i in arr:
        if isprime(i):
            res += 1
    
    return res
