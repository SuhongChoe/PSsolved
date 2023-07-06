from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 괄호가 정상적으로 처리가 되는지 여부를 묻는 문제
    # 스텍의 형태로 처리해주면 된다
    # 여괄호가 있을 때 닫괄호가 들어온다면 스택에서 뺴주면 됨
    # 아무것도 없을 때 닫괄호가 들어온다면 NO를 출력

    res = []

    for _ in range(int(input())):
        ps = input().strip()
        s = []
        for i in range(len(ps)):
            if ps[i] == '(':
                s.append(ps[i])
            else: # ps[i] == ')'
                if not s:
                    res.append('NO')
                    break
                s.pop()
        else:
            if s: res.append('NO')
            else: res.append('YES')

    return '\n'.join(res)
    
if __name__ == "__main__":
    print(str(function()))