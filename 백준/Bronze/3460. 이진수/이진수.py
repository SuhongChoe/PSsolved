from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # T 테스트 케이스
    # T 만큼 실행됨
    # 출력은 1의 위치를 모두 찾는 것

    # solution
    # count하면 될것 같다

    # 비트연산 사용하면 될듯
    # 1과 입력받은 수를 >> 로 옮기면서

    T = []

    for _ in range(int(input())):
        n = int(input())

        arr = [str(i) for i in range(len(bin(n)[2:])) if ((n >> i) & 1) == 1]

        T.append(' '.join(arr))

    return '\n'.join(T)
    
if __name__ == "__main__":
    print(str(function()))