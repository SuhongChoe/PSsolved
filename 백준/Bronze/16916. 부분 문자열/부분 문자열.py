import sys
input = sys.stdin.readline
print = sys.stdout.write

# def function():
#     # write code down
#     # p가 s의 부분문자열인지 확인
#     # 부분문자열이란 문자열의 연속된 부분
#
#     # input
#     # 1. s : 전체 문자열 (1 <= len(s) <= 1000000)
#     # 2. p : 확인할 부분 문자열 (1 <= len(p) <= 1000000)
#
#     # output
#     # 1. 부분 문자열이면 1 아니면 0
#
#     # solution
#     # kmp 알고리즘을 통해 존재한다면 return 하는 방식으로 진행
#
#     s = input().strip()
#     p = input().strip()
#     res = 1 if kmp_search(s, p) else 0
#
#     return str(res)
#
# def kmp_table(p):
#     p_len = len(p)
#     fail = [0]*p_len
#
#     j = 0
#     for i in range(1, p_len):
#         while j>0 and p[i]!=p[j]:
#             j = fail[j-1]
#         if p[i]==p[j]:
#             j+=1
#             fail[i] = j
#
#     return fail
#
# def kmp_search(s, p):
#     s_len, p_len = len(s), len(p)
#     table = kmp_table(p)
#
#     j = 0
#
#     for i in range(s_len):
#         while j>0 and s[i]!=p[j]:
#             j = table[j-1]
#         if s[i]==p[j]:
#             if j == p_len-1:
#                 return True
#             else:
#                 j += 1
#
#     return False
            
# def function():
#     # write code down

#     s = input().strip()
#     p = input().strip()

#     table = kmp_table(p)

#     n, m = len(s), len(p)
#     res = 0

#     j = 0
#     for i in range(n):
#         while j > 0 and s[i]!=p[j]:
#             j = table[j-1]
#         if s[i]==p[j]:
#             if j==m-1:
#                 res = 1
#                 break
#             j += 1

#     return str(res)

# def kmp_table(pattern):
#     n = len(pattern)

#     table = [0]*n

#     j = 0
#     for i in range(1, n):
#         while j > 0 and pattern[i]!=pattern[j]:
#             j = table[j-1]
#         if pattern[i]==pattern[j]:
#             j += 1
#             table[i] = j

#     return table

def function():
    # write code down

    s = input().strip()
    p = input().strip()

    table = kmp_table(p)
    res = 0

    j = 0
    n, m = len(s), len(p)
    for i in range(n):
        while j > 0 and s[i]!=p[j]:
            j = table[j-1]
        if s[i]==p[j]:
            j += 1
            if j==m:
                res = 1
                break
    
    return str(res)

def kmp_table(pattern):
    n = len(pattern)

    table = [0]*n
    
    j = 0
    for i in range(1, n):
        while j > 0 and pattern[i]!=pattern[j]:
            j = table[j-1]
        if pattern[i]==pattern[j]:
            j += 1
            table[i] = j

    return table

if __name__ == '__main__':
    print(function())