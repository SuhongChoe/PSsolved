from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 소문자로 이루어진 단어 S
    # 포함되어있는 경우는 처음 등장하는 위치
    # 포함안되는 단어는 -1

    # solution
    # defaultdict 자료구조를 활용한다면 len(S)만큼 실행됨

    from collections import defaultdict

    dic = defaultdict(int)

    S = input().strip()

    for i, c in enumerate(S):
        if dic[c]==0:
            dic[c] = i + 1 # 시작위치와 추후 알파벳을 출력할때 의 값이 같음을 방지하기 위함

    return ' '.join(map(str, [dic[c]-1 if dic[c]!=0 else -1 for c in 'abcdefghijklmnopqrstuvwxyz']))
    
if __name__ == "__main__":
    print(str(function()))