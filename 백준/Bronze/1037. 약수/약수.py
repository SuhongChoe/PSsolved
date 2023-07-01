from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 1과 N을 제외한 약수가 나열됨
    # 첫째 줄 N의 약수 개수
    # 둘째 줄 1, N을 제외한 약수들
    # max * min 값이 찾고자 하는 N 이 됨

    _ = input()
    A_lst = list(map(int, input().split()))

    return max(A_lst) * min(A_lst)
    
if __name__ == "__main__":
    print(str(function()))