import sys
input = sys.stdin.readline
output = sys.stdout.write

def function():
    # write code down
    # 입력형태
    # 1. T 테스트케이스
    # 2. n 지원자 수
    # 3~. 지원자의 성적 서류, 면접 점수
    
    res = []
    
    for _ in range(int(input())):
        n = int(input())
        grades = [0]*n
        for i in range(n):
            d, i = map(int, input().split())
            grades[d-1] = i
        
        cnt = 1
        lowest = grades[0]
        for i in range(1, n):
            score = grades[i]
            if score < lowest:
                cnt += 1
                lowest = score
        
        res.append(cnt)
        
    return '\n'.join(map(str, res))

if __name__ == "__main__":
    print(function())