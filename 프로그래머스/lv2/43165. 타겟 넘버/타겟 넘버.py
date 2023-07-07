def dfs(numbers, s, target, res):
    if not numbers:
        if s == target:
            res[0] += 1
    else:
        n = numbers[0]
        dfs(numbers[1:], s - n, target, res)
        dfs(numbers[1:], s + n, target, res)
        

def solution(numbers, target):
    # n개의 음이 아닌 정수
    # 이들을 전부 더하거나 뺴서 target을 만드려고 함
    # 주어지는 숫자개수는 2개 이상 20개
    
    # solution
    # 각숫자가 + - 일 모든 경우를 적절히 섞어 완전탐색으로 푼다면 2**20 약 100만
    # 시간복잡도 괜찮음
    
    res = [0]
    
    dfs(numbers, 0, target, res)
    
    return res[0]