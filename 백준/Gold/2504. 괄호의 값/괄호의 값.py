from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code

    # input
    # 1. bracket : 괄호가 입력됨 (1 <= len(bracket <= 30)

    # output
    # 1. 괄호값이 나타내는 정수 (단, 올바르지 못하다면 0 출력)

    # solution
    # 분배법칙을 사용하면 됨
    # 그렇게 한다면 누적곱을 사용하여 해결 할 수 있음
    # 스텍 뿐만 아니라 이미 더했는지 확인하는 절차도 필요함! 왜냐하면 중복으로 더하지 않기 위해서

    s = []

    res = 0
    tmp = 1
    bracket = input().strip()

    for i in range(len(bracket)):
        if bracket[i] == '(':
            s.append(bracket[i])
            tmp*=2
        elif bracket[i] == '[':
            s.append(bracket[i])
            tmp*=3
        elif s and s[-1] == '(' and bracket[i] == ')':
            if bracket[i-1] == '(': res+=tmp
            tmp//=2
            s.pop()
        elif s and s[-1] == '[' and bracket[i] == ']':
            if bracket[i-1] == '[': res+=tmp
            tmp//=3
            s.pop()
        else:
            res = 0
            break

    return str(res) if not s else str(0)

# (2+(3)*3)*2+2*3
# 2*2+2*3*3+2*3

if __name__ == "__main__":
    print(function())