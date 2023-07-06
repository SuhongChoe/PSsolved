from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 단어를 뒤집어서 출력하는 문제

    sents = [' '.join(map(lambda x: x[::-1], input().split())) for _ in range(int(input()))]

    return '\n'.join(sents)
    
if __name__ == "__main__":
    print(str(function()))