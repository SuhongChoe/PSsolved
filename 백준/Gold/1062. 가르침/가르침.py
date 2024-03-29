import sys
input = sys.stdin.readline
print = sys.stdout.write

# # def function():
#     # write code down
#     # k개의 글자를 알려주었을때 주어진 글자에서 읽을 수 있는 최대 단어의 개수

#     # input
#     # 1. n, k : 단어의 개수, 가르칠 글자 개수 (1 <= n <= 50, 0 <= k <= 26)
#     # 2~. words : 단어들 (8 <= len(words[i]) <= 15) (anta로 시작, tica로 끝남, 중복 없음)

#     # output
#     # 1. 읽을 수 있는 단어 개수의 최대값


#     # solution
#     # backtracking 을 통해 문제를 해결함
#     # 1. 기존의 단어set에 무조건 배워야하는 단어 'antic'를 빼고 저장
#     # 2. backtracking을 통해 k-5에 단어가 도달할 경우 최대 몇개가 되는지 전부 저장
#     # 나의 궁금한 점 백트래킹은 어떻게 시간복잡도를 계산하는가?
    
#     # n, k = map(int, input().split())
#     # learned = set('antatica')
#     # words = [set(input().strip())-learned for _ in range(n)]

#     # if k < 5:
#     #     return str(0)
#     # elif k == 26:
#     #     return str(n)
#     # else:
#     #     res = [0]
    
#     #     backtracking(0, learned, k-5, res, words)
    
# #         return str(res[0])

# # def backtracking(idx, learned, k, res, words):
#     # if k==0:
#     #     cnt = 0
#     #     for word in words:
#     #         if not word - learned:
#     #             cnt+=1
#     #     res[0] = max(cnt, res[0])
#     #     return
    
#     # for i in range(idx, 26):
#     #     c = chr(i+97)
#     #     if not c in learned:
#     #         learned.add(c)
#     #         backtracking(i, learned, k-1, res, words)
#     #         learned.remove(c)



# # def function():
# #     # write code down
# #     # 가르칠 수 있는 글자의 개수가 한정적 일 때 읽을 수 있는 단어의 최대 개수

# #     # input
# #     # 1. n, k : 단어의 개수, 가르칠 수 있는 글자 개수 (0 <= n <= 50, 0 <= k <= 26)
# #     # 2~n+1. word : 주어진 단어 (8 <= len(word) <= 15) (단, anta로 시작, tica로 끝난다)
# #     # 따라서 무조건 배워야 하는 글자는 antic가 된다.

# #     # output
# #     # 학생들이 읽을 수 있는 단어의 최대 값
    
# #     n, k = map(int, input().split())
# #     words = [set(input().strip()) for _ in range(n)]
    
# #     if k<5:
# #         return str(0)
# #     elif k==26:
# #         return str(n)
        
# #     res = [0]
    
# #     learned = [False]*26
# #     for c in 'antic':
# #         learned[ord(c)-ord('a')] = True
    
# #     backtracking(0, learned, words, res, k-5)
    
# #     return str(res[0])

# # def backtracking(idx, learned, words, res, k):
# #     if k==0:
# #         cnt = 0
# #         for word in words:
# #             for c in word:
# #                 if not learned[ord(c)-ord('a')]:
# #                     break
# #             else:
# #                 cnt+=1
# #         res[0] = max(cnt, res[0])
# #         return

# #     for i in range(idx, 26):
# #         if not learned[i]:
# #             learned[i] = True
# #             backtracking(i+1, learned, words, res, k-1)
# #             learned[i] = False

# def function():
#     # write code down

#     # input
#     # 1, n, k : 주어진 단어 개수, 배울수 있는 글자 개수 (1 <= n <= 50, 0 <= k <= 26)
#     # 2~. arr : 주어진 n개의 단어

#     # output
#     # 1. 읽을 수 있는 단어의 최대 갯수
#     from itertools import combinations

#     n, k = map(int, input().split())

#     antic = set('antic')
    
#     arr = [set(input().strip()) - antic for _ in range(n)]

#     res = 0

#     if k >= 5:
#         learn = set().union(*arr) # 배울 수 있는 글자
#         c = combinations(learn, min(k-5, len(learn))) # 그 중에 선택
    
#         for choice_chr in c:
#             cnt = sum(map(set(choice_chr).issuperset, arr))
#             res = max(res, cnt)

#     return str(res)

#     # 1. n, k : 주어진 단어, 가르칠 수 있는 글자 (1 <= n <= 50, 0 <= k <= 26)
#     # 2~. arr[i] : 단어들

#     # output
#     # 1. 단어 개수의 최대값

#     global arr, res

#     n, k = map(int, input().split())
#     arr = [set(input().strip()) for _ in range(n)]

#     res = 0

#     if k < 5:
#         return str(0)
#     elif k == 26:
#         return str(n)

#     learned = set('antic')
#     k -= 5

#     backtracking(ord('a'), learned, k)

#     return str(res)

# def backtracking(start, learned, k):
#     global arr, res

#     if k == 0:
#         cnt = 0
#         for s in arr:
#             if not s - learned:
#                 cnt += 1

#         res = max(res, cnt)

#         return

#     for i in range(start, ord('z')+1):
#         c = chr(i)
#         if not c in learned:
#             learned.add(c)
#             backtracking(i+1, learned, k-1)
#             learned.remove(c)


def function():
    # write code down
    from itertools import combinations

    n, k = map(int, input().split())
    antic = set('antic')
    arr = [set(input().strip()) - antic for _ in range(n)]

    if k < 5:
        return str(0)

    word = set().union(*arr)

    c = map(set, combinations(word, min(len(word), k-5)))

    res = max(sum(map(learned.issuperset, arr)) for learned in c)
    
    return str(res)

if __name__ == '__main__':
    print(function())
