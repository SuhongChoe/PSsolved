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

    # 알파벳을 ord와 chr을 이용한다면 abcdefghijklmnopqrstuvwxyz 이렇게 쓰는것보다
    # for i in range(ord(a), ord(z)+1): 이렇게 써서 chr(i)를 활용하는 것이 나음

    # 단어의 길이가 100이므로 find를 써도 무방함, 없으면 -1을 출력하기에

    S = input().strip()

    return ' '.join(map(str, [S.find(chr(i)) for i in range(ord('a'), ord('z')+1)]))
    
if __name__ == "__main__":
    print(str(function()))