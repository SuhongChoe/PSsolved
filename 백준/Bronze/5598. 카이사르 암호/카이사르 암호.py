from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 카이사르 암호는 알파벳을 세칸 뛰워 암호화함
    # 문제에서는 암호화 된것을 복호화 한 문자열을 출력하는 것을 원함
    # 대문자 알파벳으로 구성된 단어로 최대 1000자임
    # ord 써서 - 3 한것을 chr 하면 될듯

    caesar = input().strip()

    return ''.join(map(lambda x : chr(ord('A')+(ord(x)-ord('A')-3)%26), caesar))
    
if __name__ == "__main__":
    print(function())