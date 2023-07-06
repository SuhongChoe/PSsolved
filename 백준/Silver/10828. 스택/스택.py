import sys
input=sys.stdin.readline
N=int(input().strip())
stack=[]
for i in range(N):
    arr=input().strip().split()
    if arr[0]=='push':
        stack.append(arr[1])
    elif arr[0]=='pop':
        if len(stack)==0:
            print(-1)
        else:
            print(stack.pop())
    elif arr[0]=='size':
        print(len(stack))
    elif arr[0]=='empty':
        if len(stack)==0:
            print(1)
        else:
            print(0)
    elif arr[0]=='top':
        if len(stack)==0:
            print(-1)
        else:
            print(stack[len(stack)-1])
